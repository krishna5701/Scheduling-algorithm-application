package com.example.scheduling.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class InputDisk implements Parcelable {
   private int currhead;
   private int[] requestq;

   public InputDisk(InputDisk inpd){
        currhead=inpd.currhead;
        requestq=inpd.requestq;
    }

    protected InputDisk(Parcel in) {
        currhead=in.readInt();
        in.readIntArray(requestq);
    }

    public InputDisk(){

    }


    public static final Creator<InputDisk> CREATOR = new Creator<InputDisk>() {
        @Override
        public InputDisk createFromParcel(Parcel in) {
            return new InputDisk(in);
        }

        @Override
        public InputDisk[] newArray(int size) {
            return new InputDisk[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(currhead);
       dest.writeIntArray(requestq);
    }
    //COMPARE TWO Input Objects on the basis of arrival time
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public int compareTo(InputDisk d){return Integer.compare(currhead,d.currhead);}
    public int getCurrentHead(){return currhead;}
    public int[] getRequestq() {
        return requestq;
    }

    public void setCurrhead(int currhead) {
        this.currhead = currhead;
    }

    public void setRequestq(int[] requestq) {
        this.requestq = requestq;
    }
}


