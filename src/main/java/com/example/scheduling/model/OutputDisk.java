package com.example.scheduling.model;

import android.os.Parcel;
import android.os.Parcelable;

public class OutputDisk implements Parcelable {
    public int seek_run=0;
    private int[] seekseq;
    protected OutputDisk(Parcel in) {
        seek_run=in.readInt();
        in.readIntArray(seekseq);
    }
    public OutputDisk(){

    }
    public OutputDisk(int sr,int[] seq){
        this.seek_run=sr;
        this.seekseq=seq;
    }


    public static final Creator<OutputDisk> CREATOR = new Creator<OutputDisk>() {
        @Override
        public OutputDisk createFromParcel(Parcel in) {
            return new OutputDisk(in);
        }

        @Override
        public OutputDisk[] newArray(int size) {
            return new OutputDisk[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(seek_run);
        dest.writeIntArray(seekseq);
    }

    public int getSeek_run() {
        return seek_run;
    }

    public void setSeekseq(int[] seekseq) {
        this.seekseq = seekseq;
    }

    public void setSeek_run(int seek_run) {
        this.seek_run = seek_run;
    }

    public int[] getSeekseq() {
        return seekseq;
    }


}
