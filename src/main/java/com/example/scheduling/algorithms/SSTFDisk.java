package com.example.scheduling.algorithms;
class node {

    // represent difference between
    // head position and track number
    int distance = 0;

    // true if track has been accessed
    boolean accessed = false;
}
public class SSTFDisk {
    int seek_count=0;
    int[] seek_sequence;
    // Calculates difference of each
    // track number with the head position
    public static void calculateDifference(int queue[],
                                           int head, node diff[]) {
        for (int i = 0; i < diff.length; i++)
            diff[i].distance = Math.abs(queue[i] - head);
    }

    // find unaccessed track
    // which is at minimum distance from head
    public static int findMin(node diff[]) {
        int index = -1, minimum = Integer.MAX_VALUE;

        for (int i = 0; i < diff.length; i++) {
            if (!diff[i].accessed && minimum > diff[i].distance) {

                minimum = diff[i].distance;
                index = i;
            }
        }
        return index;
    }

    public static SSTFDisk shortestSeekTimeFirst(int request[], int head) {
        SSTFDisk out = new SSTFDisk();
        SSTFDisk tmp = new SSTFDisk();
        if (request.length == 0) {
            return null;
        } else {

            // create array of objects of class node
            node diff[] = new node[request.length];

            // initialize array
            for (int i = 0; i < diff.length; i++)

                diff[i] = new node();

            // count total number of seek operation
            tmp.seek_count = 0;

            // stores sequence in which disk access is done
            tmp.seek_sequence = new int[request.length + 1];

            for (int i = 0; i < request.length; i++) {

                tmp.seek_sequence[i] = head;
                calculateDifference(request, head, diff);

                int index = findMin(diff);

                diff[index].accessed = true;

                // increase the total count
                tmp.seek_count += diff[index].distance;

                // accessed track is now new head
                head = request[index];
            }
            out.setSeek_count(tmp.seek_count);

            // for last accessed track
            tmp.seek_sequence[tmp.seek_sequence.length - 1] = head;
            out.setSeek_sequence(tmp.seek_sequence);

        }
        return out;
    }

    public int getSeek_count() {
        return seek_count;
    }

    public int[] getSeek_sequence() {
        return seek_sequence;
    }

    public void setSeek_count(int seek_count) {
        this.seek_count = seek_count;
    }

    public void setSeek_sequence(int[] seek_sequence) {
        this.seek_sequence = seek_sequence;
    }
}
