package com.example.eva1_12_clima;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class clima_adaptador extends ArrayAdapter<Clima> {

    private Context context;
    private int layout;
    //  private Clima[] cCiudades;
    private List<Clima> cCiudades;

    public clima_adaptador(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context= context;
        this.layout= resource;
        this.cCiudades = objects;

    }

    //

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //FILA: NO EXISTA

        if (convertView == null){// PRIMERA VEZ QUE SE MUESTRA LA LISTA

        convertView = ((Activity)context).getLayoutInflater().inflate(layout,parent, false);
        }/*else{
            //FILA: SI EXISTE Y HAY QUE LLENAR
        }*/
        //vincularlos para poder usarlos
        ImageView imgVwClima;
        TextView txtVwCd,txtVwTemp,txtVwDesc;
        imgVwClima = convertView.findViewById(R.id.imageView);
        txtVwCd = convertView.findViewById(R.id.txtCity);
        txtVwTemp = convertView.findViewById(R.id.txTemp);
        txtVwDesc = convertView.findViewById(R.id.txtDesc);

        //LLenar los widgets con datos (lista cCiudades)
        Clima climaCiudad =  cCiudades.get(position);
        imgVwClima.setImageResource(climaCiudad.getImagen());
        txtVwCd.setText(climaCiudad.getCity());
        txtVwTemp.setText(climaCiudad.getTemp() + " ° C");
        txtVwDesc.setText(climaCiudad.getDesc());

        /*imgVwClima.setImageResource(cCiudades[position].getImagen());
        txtVwCd.setText(cCiudades[position].getCity());
        txtVwTemp.setText(cCiudades[position].getTemp() + " ° C");
        txtVwDesc.setText(cCiudades[position].getDesc());*/

        return convertView;
    }
}
