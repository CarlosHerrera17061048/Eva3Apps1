package com.example.eva3_6_handler_message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtViewmen;

    Thread thread;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //Aqui modificamos la interfaz grafica
            //Trabajo ligero --> Una tarea intensa  va a trabjar la ui
            String cade =(String) msg.obj;
            int what = msg.what;
            txtViewmen.append("El hilo = " + what + " imprime: " + cade + "\n");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtViewmen = findViewById(R.id.textView);
        //txtViewmen.setText("YIKEs");
        Runnable miRunnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(true){
                    try {
                        Thread.sleep(1000);
                        String cade = "i + " + i;
                        i++;

                        // Solicitamos un mensaje
                        // Poner info en el mensaje
                            Message message = handler.obtainMessage(1000,cade);
                            //Devolvero
                            handler.sendMessage(message);

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