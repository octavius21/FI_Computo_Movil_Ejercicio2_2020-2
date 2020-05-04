package com.example.ejercicio2lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejercicio2lista.Objetos.Adaptador;
import com.example.ejercicio2lista.Objetos.Anime;
import com.example.ejercicio2lista.Objetos.ArregloAnime;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private static final String LOGTAG="Informacion2";
    ListView lvanimes;
    Anime anime;
    ArrayList<Anime> arrayList= new ArrayList<Anime>();
    int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvanimes=findViewById(R.id.lvanimes);

        Bundle bundle =new Bundle();
        bundle= getIntent().getExtras();
        arrayList=(ArrayList<Anime>)bundle.getSerializable("array");
        contador=bundle.getInt("contador");


        Adaptador adaptador=new Adaptador(this,arrayList,contador);
        lvanimes.setAdapter(adaptador);



        Log.i(LOGTAG, arrayList.get(contador).getId()+arrayList.get(contador).getTitulo()+arrayList.get(contador).getGenero()+arrayList.get(contador).getAño()+arrayList.get(contador).getTemp()+arrayList.get(contador).getCap()+arrayList.get(contador).getCalif()+arrayList.get(contador).getLike());
        lvanimes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main2Activity.this,"El id: "+id,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
