package com.example.scheduling.algorithms;

import com.example.scheduling.MainActivity2;
import com.example.scheduling.model.InputDisk;
import com.example.scheduling.model.OutputDisk;

public class FCFSDisk{
    private int stsum=0,curtrack,distance;
    int array[];
    public FCFSDisk getOutput(int head,int[] reqq){
        FCFSDisk out=new FCFSDisk();
        FCFSDisk tmp= new FCFSDisk();
        tmp.setArray(reqq);
            for(int i=0;i<reqq.length;i++){
                curtrack=reqq[i];
                distance=Math.abs(curtrack-head);
                stsum+=distance;
                tmp.setStsum(stsum);
                head=curtrack;
            }
            out=tmp;
        return out;
    }

    public int getCurtrack() {
        return curtrack;
    }

    public int getDistance() {
        return distance;
    }

    public int getStsum() {
        return stsum;
    }

    public void setCurtrack(int curtrack) {
        this.curtrack = curtrack;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setStsum(int stsum) {
        this.stsum = stsum;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}


