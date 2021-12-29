package com.example.scheduling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Definitions extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.definition_chooser);
    }

    public void FCFSdescription(View view){
        Intent int3 = new Intent(this, FCFSDES.class);
        startActivity(int3);

    }

    public void SSTFdescription(View view) {
        Intent int4 = new Intent(this, SSTFDES.class);
        startActivity(int4);

    }

    public void SCANdescription(View view) {
        Intent int5 = new Intent(this, SCANDES.class);
        startActivity(int5);

    }

    public void CSCANdescription(View view) {
        Intent int6 = new Intent(this, CSCANDES.class);
        startActivity(int6);
    }

    public void LOOKdescription(View view) {
        Intent int7 = new Intent(this, LOOKDES.class);
        startActivity(int7);
    }

    public void CLOOKdescription(View view) {
        Intent int8 = new Intent(this, CLOOKDES.class);
        startActivity(int8);
    }


}

