package com.example.scheduling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.scheduling.model.InputDisk;


public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    EditText currenthead, request;
    ConstraintLayout mainlay;
    Button upload;
    public InputDisk inpdsk;
    int head;
    int[] requestq;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diskactivity);
        currenthead = (EditText)findViewById(R.id.curr);
        request = (EditText)findViewById(R.id.request);
        upload = (Button)findViewById(R.id.upload);
        mainlay = (ConstraintLayout)findViewById(R.id.constLay);


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (datathere()) {
                        Intent intent = new Intent(MainActivity2.this, AlgoChooser.class);
                        intent.putExtra("head",head);
                        intent.putExtra("requestqueue",requestq);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });


    }

    public boolean datathere() {
        try {
            boolean next=false;
            int flag=0;
            {
               {
                    InputDisk in = new InputDisk();
                    String rqq = ((TextView) mainlay.findViewById(R.id.request)).getText().toString();
                    String[] strArray = rqq.split(" ");
                    int size = strArray.length;
                    head=Integer.parseInt(currenthead.getText().toString());
                    requestq=new int[size];
                    for (int j = 0; j < size; j++) {
                        requestq[j] = Integer.parseInt(strArray[j]);
                    }
                    in.setRequestq(requestq);
                    int h=(Integer.parseInt(currenthead.getText().toString()));
                    if(h>=200 || h<0){
                        Toast.makeText(this, "Enter Valid Head Value", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                    for(int k=0;k<requestq.length;k++){
                        if(requestq[k]>=200|| requestq[k]<=0|| requestq[k]==h){
                            Toast.makeText(this, "Enter Valid Request Queue", Toast.LENGTH_SHORT).show();
                            flag++;
                        }
                        if(flag!=0){
                            return false;
                        }
                    }

                    in.setCurrhead(Integer.parseInt(currenthead.getText().toString()));
                    inpdsk = in;
                    next=true;
            }
            return next;

        }} catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    @Override
    public void onClick(View v) {

    }
}