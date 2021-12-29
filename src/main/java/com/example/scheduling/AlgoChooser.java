package com.example.scheduling;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.scheduling.algorithms.CLOOKDisk;
import com.example.scheduling.algorithms.CSCANDisk;
import com.example.scheduling.algorithms.FCFS;
import com.example.scheduling.algorithms.FCFSDisk;
import com.example.scheduling.algorithms.LOOKDisk;
import com.example.scheduling.algorithms.SCANDisk;
import com.example.scheduling.algorithms.SSTFDisk;
import com.example.scheduling.model.InputDisk;
import com.example.scheduling.model.OutputDisk;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Arrays;


public class AlgoChooser extends AppCompatActivity implements View.OnClickListener {

    Button fcfs, sstf, look, scan, clook, cscan,right,left,mix;
    GraphView fcfsg,scang,sstfg,cscang,lookg,clookg,scanrg,lookrg,compare;
    TextView seekc, seekq;
    ConstraintLayout algos;
    MainActivity2 ma2;
    Parcelable p;
    InputDisk input = new InputDisk();
    String direct= new String();
    int head;
    int[] requestq;
    OutputDisk outputs = new OutputDisk();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algochoose);
        initViews();
        fcfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compare.setVisibility(View.INVISIBLE);
                    sstfg.setVisibility(View.INVISIBLE);
                    cscang.setVisibility(View.INVISIBLE);
                    clookg.setVisibility(View.INVISIBLE);
                    lookg.setVisibility(View.INVISIBLE);
                    scang.setVisibility(View.INVISIBLE);
                    scanrg.setVisibility(View.INVISIBLE);
                    lookrg.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.INVISIBLE);
                    left.setVisibility(View.INVISIBLE);
                    FCFSDisk fcfs = new FCFSDisk();
                    FCFSDisk fcfs1 = fcfs.getOutput(head, requestq);
                    seekc.setText("Seek Count=" + Integer.toString(fcfs1.getStsum()));
                    seekq.setText("Seek Sequence=" + Arrays.toString(fcfs1.getArray()));
                    fcfsg.setVisibility(View.VISIBLE);
                    LineGraphSeries<DataPoint> seriesfcfs = new LineGraphSeries<>(data(fcfs1.getArray()));
                    Toast.makeText(AlgoChooser.this, "Y Axis is the Seek Sequence and X Axis is Index Number", Toast.LENGTH_SHORT).show();
                    fcfsg.addSeries(seriesfcfs);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            ;
        });
        sstf.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                try {
                    compare.setVisibility(View.INVISIBLE);
                    fcfsg.setVisibility(View.INVISIBLE);
                    cscang.setVisibility(View.INVISIBLE);
                    clookg.setVisibility(View.INVISIBLE);
                    scang.setVisibility(View.INVISIBLE);
                    lookg.setVisibility(View.INVISIBLE);
                    scanrg.setVisibility(View.INVISIBLE);
                    lookrg.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.INVISIBLE);
                    left.setVisibility(View.INVISIBLE);
                    SSTFDisk sstf = new SSTFDisk();
                    SSTFDisk sstf1 = sstf.shortestSeekTimeFirst(requestq, head);
                    seekc.setText("Seek Count= " + Integer.toString(sstf1.getSeek_count()));
                    seekq.setText("Seek Sequence= " + Arrays.toString(sstf1.getSeek_sequence()));
                    sstfg.setVisibility(View.VISIBLE);
                    LineGraphSeries<DataPoint> seriessstf = new LineGraphSeries<>(data(sstf1.getSeek_sequence()));
                    sstfg.addSeries(seriessstf);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
        clook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compare.setVisibility(View.INVISIBLE);
                    sstfg.setVisibility(View.INVISIBLE);
                    fcfsg.setVisibility(View.INVISIBLE);
                    cscang.setVisibility(View.INVISIBLE);
                    scang.setVisibility(View.INVISIBLE);
                    lookg.setVisibility(View.INVISIBLE);
                    scanrg.setVisibility(View.INVISIBLE);
                    lookrg.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.INVISIBLE);
                    left.setVisibility(View.INVISIBLE);
                    CLOOKDisk clook = new CLOOKDisk();
                    CLOOKDisk clook1 = clook.CLOOK(requestq, head);
                    seekc.setText("Seek Count=" + Integer.toString(clook1.getSeek_count()));
                    seekq.setText("Seek Sequence=" + Arrays.toString(clook1.getSeeksq()));
                    clookg.setVisibility(View.VISIBLE);
                    LineGraphSeries<DataPoint> seriesclook = new LineGraphSeries<>(data((clook1.getSeeksq())));
                    clookg.addSeries(seriesclook);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }


        });
        look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compare.setVisibility(View.INVISIBLE);
                    sstfg.setVisibility(View.INVISIBLE);
                    cscang.setVisibility(View.INVISIBLE);
                    clookg.setVisibility(View.INVISIBLE);
                    fcfsg.setVisibility(View.INVISIBLE);
                    scang.setVisibility(View.INVISIBLE);
                    scanrg.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.VISIBLE);
                    left.setVisibility(View.VISIBLE);
                    final LOOKDisk look = new LOOKDisk();
                    final LOOKDisk look1 = look.LOOK(requestq, head,"right");
                    final LOOKDisk look2=look.LOOK(requestq,head,"left");
                   right.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           seekc.setText("Seek Count =" + Integer.toString(look1.getSeek_count()));
                           seekq.setText("Seek Sequence =" + Arrays.toString(look1.getSeek_sequence()));
                           lookrg.setVisibility(View.VISIBLE);
                           lookg.setVisibility(View.INVISIBLE);
                           LineGraphSeries<DataPoint> serieslook = new LineGraphSeries<>(data(look1.getSeek_sequence()));
                           Toast.makeText(AlgoChooser.this, "Y Axis is the Seek Sequence and X Axis is Index Number", Toast.LENGTH_SHORT).show();
                           lookrg.addSeries(serieslook);
                       }
                   });
                   left.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           seekc.setText("Seek Count =" + Integer.toString(look2.getSeek_count()));
                           seekq.setText("Seek Sequence =" + Arrays.toString(look2.getSeek_sequence()));
                           lookrg.setVisibility(View.INVISIBLE);
                           lookg.setVisibility(View.VISIBLE);
                           LineGraphSeries<DataPoint> serieslook = new LineGraphSeries<>(data(look2.getSeek_sequence()));
                           Toast.makeText(AlgoChooser.this, "Y Axis is the Seek Sequence and X Axis is Index Number", Toast.LENGTH_SHORT).show();
                           lookg.addSeries(serieslook);
                       }
                   });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        });
        cscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compare.setVisibility(View.INVISIBLE);
                    sstfg.setVisibility(View.INVISIBLE);
                    fcfsg.setVisibility(View.INVISIBLE);
                    clookg.setVisibility(View.INVISIBLE);
                    lookg.setVisibility(View.INVISIBLE);
                    lookrg.setVisibility(View.INVISIBLE);
                    scang.setVisibility(View.INVISIBLE);
                    scanrg.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.INVISIBLE);
                    left.setVisibility(View.INVISIBLE);
                    CSCANDisk cscan = new CSCANDisk();
                    CSCANDisk cscan1 = cscan.algo(requestq, head);
                    seekc.setText("Seek Count=" + Integer.toString(cscan1.getSeek_count()));
                    seekq.setText("Seek Sequence=" + Arrays.toString(cscan1.getSeek_sequence()));
                    cscang.setVisibility(View.VISIBLE);
                    LineGraphSeries<DataPoint> seriescscan = new LineGraphSeries<>(data((cscan1.getSeek_sequence())));
                    cscang.addSeries(seriescscan);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }


        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compare.setVisibility(View.INVISIBLE);
                    sstfg.setVisibility(View.INVISIBLE);
                    cscang.setVisibility(View.INVISIBLE);
                    clookg.setVisibility(View.INVISIBLE);
                    fcfsg.setVisibility(View.INVISIBLE);
                    lookg.setVisibility(View.INVISIBLE);
                    lookrg.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.VISIBLE);
                    left.setVisibility(View.VISIBLE);
                    final SCANDisk scan = new SCANDisk();
                    final SCANDisk scan1 = scan.SCAN(requestq, head,"right");
                    final SCANDisk scan2=scan.SCAN(requestq,head,"left");
                    right.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            seekc.setText("Seek Count =" + Integer.toString(scan1.getSeek_count()));
                            seekq.setText("Seek Sequence =" + Arrays.toString(scan1.getSeek_sequence()));
                            scanrg.setVisibility(View.VISIBLE);
                            scang.setVisibility(View.INVISIBLE);
                            LineGraphSeries<DataPoint> seriesscan = new LineGraphSeries<>(data(scan1.getSeek_sequence()));
                            Toast.makeText(AlgoChooser.this, "Y Axis is the Seek Sequence and X Axis is Index Number", Toast.LENGTH_SHORT).show();
                            scanrg.addSeries(seriesscan);
                        }
                    });
                    left.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            scang.clearAnimation();
                            scanrg.setVisibility(View.INVISIBLE);
                            seekc.setText("Seek Count =" + Integer.toString(scan2.getSeek_count()));
                            seekq.setText("Seek Sequence =" + Arrays.toString(scan2.getSeek_sequence()));
                            scang.setVisibility(View.VISIBLE);
                            LineGraphSeries<DataPoint> seriesscan = new LineGraphSeries<>(data(scan2.getSeek_sequence()));
                            Toast.makeText(AlgoChooser.this, "Y Axis is the Seek Sequence and X Axis is Index Number", Toast.LENGTH_SHORT).show();
                            scang.addSeries(seriesscan);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        });
        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    fcfsg.setVisibility(View.INVISIBLE);
                    sstfg.setVisibility(View.INVISIBLE);
                    scang.setVisibility(View.INVISIBLE);
                    scanrg.setVisibility(View.INVISIBLE);
                    lookg.setVisibility(View.INVISIBLE);
                    lookrg.setVisibility(View.INVISIBLE);
                    cscang.setVisibility(View.INVISIBLE);
                    clookg.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.INVISIBLE);
                    left.setVisibility(View.INVISIBLE);
                    compare.setVisibility(View.VISIBLE);
                    Toast.makeText(AlgoChooser.this, "RED-FCFS,GREEN-SSTF,BLUE-SCAN,BLACK-LOOK,YELLOW-CSCAN,CYAN-CLOOK", Toast.LENGTH_LONG).show();
                    FCFSDisk fcfs1=new FCFSDisk();
                    FCFSDisk fcfs2= fcfs1.getOutput(head,requestq);
                    LineGraphSeries<DataPoint> seriesfcfs = new LineGraphSeries<>(data(fcfs2.getArray()));
                    seriesfcfs.setColor(Color.RED);
                    compare.addSeries(seriesfcfs);
                    SSTFDisk sstf1=new SSTFDisk();
                    SSTFDisk sstf2= sstf1.shortestSeekTimeFirst(requestq,head);
                    LineGraphSeries<DataPoint> seriessstf = new LineGraphSeries<>(data(sstf2.getSeek_sequence()));
                    seriessstf.setColor(Color.GREEN);
                    compare.addSeries(seriessstf);
                    SCANDisk scan1=new SCANDisk();
                    SCANDisk scan2= scan1.SCAN(requestq,head,"left");
                    LineGraphSeries<DataPoint> seriesscan = new LineGraphSeries<>(data(scan2.getSeek_sequence()));
                    seriesscan.setColor(Color.BLUE);
                    compare.addSeries(seriesscan);
                    LOOKDisk look1=new LOOKDisk();
                    LOOKDisk look2= look1.LOOK(requestq,head,"left");
                    LineGraphSeries<DataPoint> serieslook = new LineGraphSeries<>(data(look2.getSeek_sequence()));
                    serieslook.setColor(Color.BLACK);
                    compare.addSeries(serieslook);
                    CSCANDisk cscan1=new CSCANDisk();
                    CSCANDisk cscan2= cscan1.algo(requestq,head);
                    LineGraphSeries<DataPoint> seriescscan = new LineGraphSeries<>(data(cscan2.getSeek_sequence()));
                    seriescscan.setColor(Color.YELLOW);
                    compare.addSeries(seriescscan);
                    CLOOKDisk clook1=new CLOOKDisk();
                    CLOOKDisk clook2= clook1.CLOOK(requestq,head);
                    LineGraphSeries<DataPoint> seriesclook = new LineGraphSeries<>(data(clook2.getSeeksq()));
                    seriesclook.setColor(Color.CYAN);
                    compare.addSeries(seriesclook);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    private void initViews() {
        Intent intent = getIntent();
        head = intent.getIntExtra("head", 0);
        requestq = intent.getIntArrayExtra("requestqueue");
        fcfsg = (GraphView) findViewById(R.id.fcfsg);
        fcfsg.setVisibility(View.INVISIBLE);
        sstfg = (GraphView) findViewById(R.id.sstfg);
        sstfg.setVisibility(View.INVISIBLE);
        scang = (GraphView) findViewById(R.id.scanlg);
        scang.setVisibility(View.INVISIBLE);
        lookg = (GraphView) findViewById(R.id.looklg);
        lookg.setVisibility(View.INVISIBLE);
        cscang = (GraphView) findViewById(R.id.cscang);
        cscang.setVisibility(View.INVISIBLE);
        clookg = (GraphView) findViewById(R.id.clookg);
        clookg.setVisibility(View.INVISIBLE);
        fcfs = findViewById(R.id.fcfs);
        sstf = findViewById(R.id.sstf);
        look = findViewById(R.id.look);
        scan = findViewById(R.id.scan);
        clook = findViewById(R.id.clook);
        cscan = findViewById(R.id.cscan);
        algos = findViewById(R.id.voidlay);
        seekc = findViewById(R.id.seekc);
        seekq = findViewById(R.id.seekq);
        scanrg=findViewById(R.id.scanrg);
        lookrg=findViewById(R.id.lookrg);
        right=findViewById(R.id.rightbut);
        right.setVisibility(View.INVISIBLE);
        left=findViewById(R.id.leftbut);
        left.setVisibility(View.INVISIBLE);
        mix=findViewById(R.id.mix);
        compare=findViewById(R.id.mixg);
    }


    @Override
    public void onClick(View v) {

    }

    public DataPoint[] data(int[] queue){
        int n= queue.length;
        DataPoint[] values= new DataPoint[n];
        for(int i=0;i<n;i++){
            DataPoint v= new DataPoint((double)(i+1),(double)(queue[i]));
            values[i]=v;
        }
        return values;
    }
}
