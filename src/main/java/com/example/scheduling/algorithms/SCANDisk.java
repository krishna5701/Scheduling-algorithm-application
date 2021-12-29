package com.example.scheduling.algorithms;

import java.util.Collections;
import java.util.Vector;

public class SCANDisk {
    int seek_count = 0;
    int distance, cur_track;
    Vector<Integer> seek_sequence = new Vector<Integer>();
    static int disk_size = 200;
    public SCANDisk SCAN(int arr[], int head, String direction)
    {
        SCANDisk out= new SCANDisk();
        SCANDisk tmp= new SCANDisk();
        int size=arr.length;
        Vector<Integer> left = new Vector<Integer>(),
                right = new Vector<Integer>();

        // appending end values
        // which has to be visited
        // before reversing the direction
        if (direction.equals("left"))
            left.add(0);
        else if (direction.equals("right"))
            right.add(disk_size - 1);

        for (int i = 0; i < size; i++)
        {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }

        // sorting left and right vectors
        Collections.sort(left);
        Collections.sort(right);
        if (direction.equals("left"))
            {
                for (int i = left.size() - 1; i >= 0; i--)
                {
                    cur_track = left.get(i);

                    // appending current track to seek sequence
                    seek_sequence.add(cur_track);

                    // calculate absolute distance
                    distance = Math.abs(cur_track - head);

                    // increase the total count
                    seek_count += distance;

                    // accessed track is now the new head
                    head = cur_track;
                }
            }
            else if (direction.equals("right"))
            {
                for (int i = 0; i < right.size(); i++)
                {
                    cur_track = right.get(i);

                    // appending current track to seek sequence
                    seek_sequence.add(cur_track);

                    // calculate absolute distance
                    distance = Math.abs(cur_track - head);

                    // increase the total count
                    seek_count += distance;

                    // accessed track is now new head
                    head = cur_track;
                }
            }


       tmp.setSeek_count(seek_count);
        tmp.setSeek_sequence(seek_sequence);
        return tmp;
    }

    public int getSeek_count() {
        return seek_count;
    }

    public void setSeek_count(int seek_count) {
        this.seek_count = seek_count;
    }

    public int[] getSeek_sequence() {
        int count = 0, ints[] = new int[seek_sequence.size()];
        for(int i: seek_sequence) ints[count++] = i;
        return ints;
    }

    public void setSeek_sequence(Vector<Integer> seek_sequence) {
        this.seek_sequence = seek_sequence;
    }
}
