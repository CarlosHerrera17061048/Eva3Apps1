package com.example.eva3_14_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        MiClaseAsincrona miCA = new MiClaseAsincrona();
        miCA.execute(10);
        class MiClaseAsincrona extends AsyncTask <Integer,String,Void>{
            public MiClaseAsincrona() {
                super();
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            txt1.append("INICIANDO LA TAREA ASINCRONA!!\n");
            }
            @Override
            protected Void doInBackground(Integer... integers) {
                int limite = integers[0];
                for(int i = 0; i<limite;i++){
                    try {
                        Thread.sleep(1000);
                        publishProgress("i = "+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                return null;

            }

            @Override
            protected void onPostExecute(Void s) {
                super.onPostExecute(s);
                txt1.append("Fin LA TAREA ASINCRONA!!\n");

            }

            @Override
            protected void onProgressUpdate(String... values) {
                super.onProgressUpdate(values);
                txt1.append(values[0]);
            }


        }
    }
}
class MiClaseAsincrona extends AsyncTask<Integer,String,Void>{
    public MiClaseAsincrona() {
        super();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(Void s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        return null;
    }
}