package com.example.scheduling.algorithms;

import java.util.Collections;
import java.util.Vector;

public class LOOKDisk {
    int seek_count = 0;
    int distance, cur_track;
    Vector<Integer> seek_sequence = new Vector<Integer>();
    public LOOKDisk LOOK(int arr[], int head,
                     String direction)
    {
        int size=arr.length;
        LOOKDisk out= new LOOKDisk();
        LOOKDisk tmp=new LOOKDisk();
        Vector<Integer> left = new Vector<Integer>();
        Vector<Integer> right = new Vector<Integer>();
        for(int i = 0; i < size; i++)
        {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }
        Collections.sort(left);
        Collections.sort(right);
        if (direction.equals("left"))
            {
                for(int i = left.size() - 1;
                    i >= 0; i--)
                {
                    cur_track = left.get(i);

                    // Appending current track to
                    // seek sequence
                    seek_sequence.add(cur_track);

                    // Calculate absolute distance
                    distance = Math.abs(cur_track - head);

                    // Increase the total count
                    seek_count += distance;

                    // Accessed track is now the new head
                    head = cur_track;
                }
            }
            else if (direction.equals("right"))
            {
                for(int i = 0; i < right.size(); i++)
                {
                    cur_track = right.get(i);

                    // Appending current track to
                    // seek sequence
                    seek_sequence.add(cur_track);

                    // Calculate absolute distance
                    distance = Math.abs(cur_track - head);

                    // Increase the total count
                    seek_count += distance;

                    // Accessed track is now new head
                    head = cur_track;
                }
            }

        tmp.setSeek_count(seek_count);
       tmp.setSeek_sequence(seek_sequence);
       return tmp;
    }

    public void setSeek_count(int seek_count) {
        this.seek_count = seek_count;
    }

    public void setSeek_sequence(Vector<Integer> seek_sequence) {
        this.seek_sequence = seek_sequence;
    }

    public int[] getSeek_sequence() {
        int count = 0, ints[] = new int[seek_sequence.size()];
        for(int i: seek_sequence) ints[count++] = i;
        return ints;
    }

    public int getSeek_count() {
        return seek_count;
    }
}
