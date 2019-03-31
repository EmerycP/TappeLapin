package com.example.tapelelapin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] idButton;
    int idLapin;
    int good = 0;
    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idButton = new int[9];

        idButton[0] = R.id.button;
        idButton[1] = R.id.button2;
        idButton[2] = R.id.button3;
        idButton[3] = R.id.button4;
        idButton[4] = R.id.button5;
        idButton[5] = R.id.button6;
        idButton[6] = R.id.button7;
        idButton[7] = R.id.button8;
        idButton[8] = R.id.button9;

        tirage();

    }

    public void tirage(){
        for(int id: idButton){
            Button b = (Button) findViewById(id);
            b.setText("Taupe");
        }
        Random r = new Random();
        idLapin = idButton[r.nextInt(9)];
        Button b = (Button) findViewById(idLapin);
        b.setText("Lapin");
    }

    public void toucheLapin(View v){
        if(v.getId() == idLapin){
            tirage();
            Toast.makeText(MainActivity.this, "Good shit.", Toast.LENGTH_SHORT).show();
            good++;
            TextView pafs = findViewById(R.id.textView2);
            pafs.setText(good + " pafs");


        }
        else{
            tirage();
            Toast.makeText(MainActivity.this, "Wrong.", Toast.LENGTH_SHORT).show();
            wrong++;
            TextView flops = findViewById(R.id.textView3);
            flops.setText(wrong + " flops");
        }
    }
}
