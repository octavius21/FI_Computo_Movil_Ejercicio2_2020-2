package com.example.ejercicio2lista.Objetos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ejercicio2lista.Main2Activity;
import com.example.ejercicio2lista.R;

import java.io.Serializable;
import java.util.ArrayList;


public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater=null; //para usar el protottipo de celda personalizado



    Context contexto;
    ArrayList<Anime> datos;
    int contador;

    public Adaptador(Context contexto, ArrayList<Anime> arrayList, int contador) {
        this.contexto = contexto;
        this.datos=arrayList;
        this.contador=contador;
        inflater=(LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contador+1;
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.valueOf(datos.get(position).getId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista=inflater.inflate(R.layout.opcion2,null);

        TextView tvTitulo = vista.findViewById(R.id.tvTitulo);
        TextView tvGenero = vista.findViewById(R.id.tvGenero);
        TextView tvAño = vista.findViewById(R.id.tvAño);
        TextView tvTemp = vista.findViewById(R.id.tvTemp);
        TextView tvCap = vista.findViewById(R.id.tvCap);
        TextView tvCalif = vista.findViewById(R.id.tvCalif);
        TextView tvLike = vista.findViewById(R.id.tvLike);
        ImageView imageView=vista.findViewById(R.id.imageView);

        tvTitulo.setText(datos.get(position).getTitulo());
        tvGenero.setText(datos.get(position).getGenero());
        tvAño.setText(String.valueOf(datos.get(position).getAño()));
        tvTemp.setText(String.valueOf(datos.get(position).getTemp()));
        tvCap.setText(String.valueOf(datos.get(position).getCap()));
        tvCalif.setText(String.valueOf(datos.get(position).getCalif()));
        tvLike.setText(datos.get(position).getLike().toString());

        switch (tvGenero.getText().toString()) {
            case "Acción":
            case "Action":
                imageView.setImageResource(R.drawable.pandora);
                break;
            case "Sci-fi":
                imageView.setImageResource(R.drawable.ciudad);
                break;
            case"Adventure":
            case "Aventures":
            case "Aventura":
                imageView.setImageResource(R.drawable.aventura7);
            break;
            case "Fantasy":
            case "Fantaisie":
            case "Fantasia":
                imageView.setImageResource(R.drawable.shalltear);
                break;

            case "Horror":
            case "Terreur":
            case "Terror":
                imageView.setImageResource(R.drawable.terror7);
                break;

            case "Isekai":
                imageView.setImageResource(R.drawable.goblin);
                break;

            case "Game":
            case "Jeu":
            case "Juego":
                imageView.setImageResource(R.drawable.spark343);
                break;

            default:

            break;
        }


        return vista;
    }
    public Context getContexto() {
        return contexto;
    }

}
