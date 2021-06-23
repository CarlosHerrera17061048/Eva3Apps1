package com.example.eva3_load_image_post;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewCold;

    Handler handler = new Handler();
    Bitmap bitmap;
    // Trabajo pesado, en segundo plano
    Runnable background = new Runnable() {
        @Override
        public void run() {
            while (true){
                try {
                    thread.sleep(1000);
                    handler.post(foreground);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    };
    // Trabajo con la ui
    Runnable foreground = new Runnable() {
        @Override
        public void run() {

            imgViewCold = findViewById(R.id.imgViewCold);
            bitmap = descargarImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Coldplay_2017%2C_cropped_01.jpg/800px-Coldplay_2017%2C_cropped_01.jpg");
            imgViewCold.setImageBitmap(bitmap);
            imgViewCold.setImageBitmap(bitmap);

        }
    };

    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        thread = new Thread(background);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }

    private Bitmap descargarImagen(String url){
        try {
            InputStream inputStream = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}