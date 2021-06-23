package com.example.eva3_7_handler_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewBanner;
    Thread tBanner;
    int icont = 0;
    // A traves de un handler (metodo handler mesasge) interactuar con la ui
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //interactuar con la ui
            int image;
            if(icont == 0){
            image = R.drawable.top1;
            icont++;
            }else if (icont == 1) {
                image = R.drawable.top2;
                    icont++;
            }else{
        image = R.drawable.top3;
        icont = 0;
            }
            imgViewBanner.setImageResource(image);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgViewBanner = findViewById(R.id.imgViewBanner);

        tBanner = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(1000);
                        //Solicitaar MEnsaje
                        Message message = handler.obtainMessage();
                        //Enviar mensaje
                        handler.sendMessage(message);



                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        tBanner.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tBanner.interrupt();
    }
}