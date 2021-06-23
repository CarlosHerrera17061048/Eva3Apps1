package com.example.eva3_21_broadcastreceiver_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        BroadcastReceiver broadcastReceiver = new miBroadcast();
        IntentFilter intentFilter =  new IntentFilter("MI_MENSAJE");
        registerReceiver(broadcastReceiver,intentFilter);

    }
    class miBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            textView.append(intent.getStringExtra("MENSAJE")+"\n");
        }
    }
}