package com.example.eva3_5_hilos_vs_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtViewmen;

    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtViewmen = findViewById(R.id.textView);
        //txtViewmen.setText("YIKEs");
        Runnable miRunnable = new Runnable() {
            @Override
            public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                    int i=0;
                    String cade = "i = "+i;
                    i++;
                    txtViewmen.append(cade+"\n");
                    Log.wtf("RUnnable",cade);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            }
        };
         thread = new Thread(miRunnable);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}