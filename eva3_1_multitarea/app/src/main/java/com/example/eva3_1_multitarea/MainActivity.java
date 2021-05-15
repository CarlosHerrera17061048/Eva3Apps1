package com.example.eva3_1_multitarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<10; i++ ){
            try {
                sleep(1000);
                Log.wtf("HILO PRINCIPAL", " i = "+ (i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}