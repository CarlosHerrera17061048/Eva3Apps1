package com.example.eva1_12_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  /*  Clima[] climaCiudad  = {
            new Clima(R.drawable.sunny,"Chihuahua",28, "Despejado con viento"),
            new Clima(R.drawable.cloudy,"Trost",21, "riko"),
            new Clima(R.drawable.rainy,"Delicias",22, "Dfakiu"),
            new Clima(R.drawable.thunderstorm,"Juarez",25, "ciudad fea unu"),
            new Clima(R.drawable.tornado,"Nueva York",16, "the end of the fucking world niggas"),
            new Clima(R.drawable.atmospher,"Madera",19, "oh yeah"),
            new Clima(R.drawable.sunny,"Creel",15, "LA SIERRONGA"),
            new Clima(R.drawable.rainy,"Londres",10, "ahi woa vivir uwu"),
            new Clima(R.drawable.rainy,"Dema",12, "Shet Motherfucker"),
            new Clima(R.drawable.light_rain,"Ahumada",45, "feo uwu"),



    };*/

    List<Clima> lstCiudades= new ArrayList<>();
ListView lstVwClima;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lstVwClima = findViewById(R.id.lstViewClima);
      //  lstVwClima.setAdapter(new clima_adaptador(this,R.layout.mi_lista_clima,climaCiudad));
        ConexionClima cc = new ConexionClima();
        cc.execute("http://api.openweathermap.org/data/2.5/find?lat=19.5&lon=-99&cnt=30&units=metric&appid=c530d9c4ef9ee2be7837ecc184df4756");
    }
    class ConexionClima extends AsyncTask <String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
                String sUrl = strings[0];
                String sResu = null;

            try {
                URL url = new URL(sUrl);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                if (httpCon.getResponseCode()== HttpURLConnection.HTTP_OK){
                    InputStreamReader isReader = new InputStreamReader(httpCon.getInputStream());
                    BufferedReader brDatos = new BufferedReader(isReader);
                    sResu = brDatos.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.wtf("CONEXION",s);
            if(!s.equals("") || s == null){
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArrayCiudades = jsonObject.getJSONArray("list");
                    for (int i=0; i<jsonArrayCiudades.length();i++){
                        JSONObject jsonObject1 = jsonArrayCiudades.getJSONObject(i);

                        Clima climaCiudad = new Clima ();
                        climaCiudad.setCity(jsonObject1.getString("name"));
                        JSONObject jsonMain = jsonObject1.getJSONObject("main");
                        climaCiudad.setTemp(jsonMain.getDouble("temp"));
                        JSONArray jsonWeather = jsonObject1.getJSONArray("weather");
                        JSONObject jsonObjectClimaActual = jsonWeather.getJSONObject(0);
                        climaCiudad.setDesc(jsonObjectClimaActual.getString("description"));
                        int id =  jsonObjectClimaActual.getInt("id");
                        if(id <300){
                            climaCiudad.setImagen(R.drawable.thunderstorm);
                        }else if (id<400){
                            climaCiudad.setImagen(R.drawable.light_rain);

                        }else if (id<600){
                            climaCiudad.setImagen(R.drawable.rainy);

                        }else if (id<700){
                            climaCiudad.setImagen(R.drawable.snow);

                        }else if (id<800){
                            climaCiudad.setImagen(R.drawable.atmospher);

                        }else if (id<801){
                            climaCiudad.setImagen(R.drawable.sunny);

                        }else if (id<900){
                            climaCiudad.setImagen(R.drawable.cloudy);

                        }else {
                            climaCiudad.setImagen(R.drawable.tornado);
                        }
                            lstCiudades.add(climaCiudad);
                    }
                    lstVwClima.setAdapter(new clima_adaptador(MainActivity.this,
                            R.layout.mi_lista_clima,
                            lstCiudades));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

