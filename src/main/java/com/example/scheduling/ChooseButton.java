package com.example.scheduling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseButton extends AppCompatActivity {


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosefile);
    }
    public void disk(View view){try {
        Intent intent = new Intent(this, DiskChooser.class);
        startActivity(intent);
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
    public void cpu(View view){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
