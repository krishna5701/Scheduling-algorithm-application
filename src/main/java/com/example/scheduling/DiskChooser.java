package com.example.scheduling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DiskChooser extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diskchoose);
    }

    public void Algocal(View view){
        Intent int1 = new Intent(this, MainActivity2.class);
        startActivity(int1);
    }

    public void Algoinfo(View view){
        Intent int2 = new Intent(this, Definitions.class);
        startActivity(int2);
    }

}

