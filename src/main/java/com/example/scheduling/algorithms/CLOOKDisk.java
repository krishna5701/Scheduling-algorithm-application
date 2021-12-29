package com.example.scheduling.algorithms;

import java.util.Collections;
import java.util.Vector;

public class CLOOKDisk {
    int seek_count = 0;
    int distance, cur_track;
    Vector<Integer> seek_sequence=new Vector<Integer>();
    static int disk_size=200;
    public CLOOKDisk CLOOK(int arr[], int head)
    {
        int size= arr.length;
        CLOOKDisk out= new CLOOKDisk();
        CLOOKDisk tmp= new CLOOKDisk();
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
        for(int i = 0; i < right.size(); i++)
        {
            cur_track = right.get(i);
            seek_sequence.add(cur_track);
            distance = Math.abs(cur_track - head);
            seek_count += distance;
            head = cur_track;
        }
        seek_count += Math.abs(head - left.get(0));
        head = left.get(0);
        for(int i = 0; i < left.size(); i++)
        {
            cur_track = left.get(i);
            seek_sequence.add(cur_track);
            distance = Math.abs(cur_track - head);
            seek_count += distance;
            head = cur_track;
        }

        tmp.setSeek_count(seek_count);
        tmp.setSeeksq(seek_sequence);
        return tmp;
    }

    public int getSeek_count() {
        return seek_count;
    }

    public void setSeek_count(int seek_count) {
        this.seek_count = seek_count;
    }

    public int[] getSeeksq() {
        int count = 0, ints[] = new int[seek_sequence.size()];
        for(int i: seek_sequence) ints[count++] = i;
        return ints;
    }

    public void setSeeksq(Vector<Integer> seek) {
        this.seek_sequence=seek;
    }
}
