package com.example.scheduling.algorithms;

// Java program to demonstrate
// C-SCAN Disk Scheduling algorithm
import java.util.*;

public class CSCANDisk {

    public Vector<Integer> seek_sequence = new Vector<Integer>();
    static int disk_size = 200;
   public int seek_count = 0;

    public static CSCANDisk algo(int arr[], int head) {
        int distance, cur_track;
        CSCANDisk out=new CSCANDisk();
        CSCANDisk tmp=new CSCANDisk();

        Vector<Integer> left = new Vector<Integer>();
        Vector<Integer> right = new Vector<Integer>();

        left.add(0);
        right.add(disk_size - 1);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }

        Collections.sort(left);
        Collections.sort(right);

        // First service the requests
        // on the right side of the
        // head.
        for (int i = 0; i < right.size(); i++) {
            cur_track = right.get(i);

            // Appending current track to seek sequence
            tmp.seek_sequence.add(cur_track);

            // Calculate absolute distance
            distance = Math.abs(cur_track - head);

            // Increase the total count
            tmp.seek_count += distance;

            // Accessed track is now new head
            head = cur_track;
        }

        // Once reached the right end
        // jump to the beggining.
        head = 0;

        // Now service the requests again
        // which are left.
        for (int i = 0; i < left.size(); i++) {
            cur_track = left.get(i);

            // Appending current track to
            // seek sequence
            tmp.seek_sequence.add(cur_track);

            // Calculate absolute distance
            distance = Math.abs(cur_track - head);

            // Increase the total count
            tmp.seek_count += distance;

            // Accessed track is now the new head
            head = cur_track;
        }

        out.setSeek_count(tmp.seek_count);
        out.setSeek_sequence(tmp.seek_sequence);
        return out;
    }

    public void setSeek_sequence(Vector<Integer> seek_sequence) {
        this.seek_sequence = seek_sequence;
    }

    public void setSeek_count(int seek_count) {
        this.seek_count = seek_count;
    }

    public int getSeek_count() {
        return seek_count;
    }

    public int[] getSeek_sequence() {

        int count = 0, ints[] = new int[seek_sequence.size()];
        for(int i: seek_sequence) ints[count++] = i;
        return ints;
    }
}


