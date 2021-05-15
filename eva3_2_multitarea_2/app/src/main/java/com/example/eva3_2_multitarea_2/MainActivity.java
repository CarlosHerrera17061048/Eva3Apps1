    package com.example.eva3_2_multitarea_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Thread = clase para crear hilos
        //Clase Thread() = metodo run es generico
        //Crear mi propio hilo
        //Crear clase anonima
        //Sobreescribir el metodo run
        Thread mihilo = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i=0;i<10; i++ ){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("HILO PRINCIPAL", " i = "+ (i+1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        mihilo.start();
        miHIlote MiHilote = new miHIlote();
        MiHilote.start();
    }

}
class miHIlote extends Thread{
    @Override
    public void run() {

        for(int i=0;i<10; i++ ){
            try {
                Thread.sleep(1000);
                Log.wtf("HILO PRINCIPAL", " j = "+ (i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
