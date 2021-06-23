package com.example.eva3_8_load_image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imgViewCold;
    Bitmap bitmap;
    Handler handlerimg = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //Aqui mostramos la imagen
        imgViewCold.setImageBitmap(bitmap);
        }
    };
    Thread threadimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgViewCold = findViewById(R.id.imgViewCold);

        imgViewCold.setImageBitmap(bitmap);
        threadimg = new Thread(){
            @Override
            public void run() {
                super.run();
                // Aqui hacemos la conexion
                bitmap = descargarImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Coldplay_2017%2C_cropped_01.jpg/800px-Coldplay_2017%2C_cropped_01.jpg");
                Message msgimg = handlerimg.obtainMessage();
                handlerimg.sendMessage(msgimg);
            }
        };
        threadimg.start();

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