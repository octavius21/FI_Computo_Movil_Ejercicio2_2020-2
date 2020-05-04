package com.example.ejercicio2lista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejercicio2lista.Objetos.Anime;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String LOGTAG="Informacion";
    Button btnAlta;
    Spinner sGenero;
    EditText etTitulo, etAño,etTemp,etCap,etCalif,etLike;
    TextView tvTituloM, tvAñoM, tvGeneroM,tvTempM,tvCapM,tvCalifM,tvLikeM;
    Anime anime;
    String seleccion;
    ArrayList<Anime> arrayList=new ArrayList<Anime>();
    int contador=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etTitulo=findViewById(R.id.etTitulo);
        sGenero=findViewById(R.id.sGenero);
        etAño=findViewById(R.id.etAño);
        etTemp=findViewById(R.id.etTemp);
        etCap=findViewById(R.id.etCap);
        etCalif=findViewById(R.id.etCalif);
        //etLike=findViewById(R.id.etLike);
        String []opciones={" ",
                this.getResources().getString(R.string.accion),
                this.getResources().getString(R.string.adventure),
                this.getResources().getString(R.string.fantasy),
                this.getResources().getString(R.string.horror),
                this.getResources().getString(R.string.isekai),
                this.getResources().getString(R.string.scifi),
                this.getResources().getString(R.string.game)};

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        sGenero.setAdapter(arrayAdapter);


        btnAlta=findViewById(R.id.btnAlta);
        btnAlta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAlta:
                anime = new Anime();
                seleccion=sGenero.getSelectedItem().toString();

                if (seleccion.equals(" ")||etTitulo.getText().toString().isEmpty()
                ||etAño.getText().toString().isEmpty()
                ||etTemp.getText().toString().isEmpty()
                ||etCap.getText().toString().isEmpty()
                ||etCalif.getText().toString().isEmpty()){

                    Log.i(LOGTAG, "No pasa");

                    if(etTitulo.getText().toString().isEmpty())
                        etTitulo.setError(getResources().getString(R.string.obligatorio));

                    if(etAño.getText().toString().isEmpty())
                        etAño.setError(getResources().getString(R.string.obligatorio));

                    if(etTemp.getText().toString().isEmpty())
                        etTemp.setError(getResources().getString(R.string.obligatorio));

                    if(etCap.getText().toString().isEmpty())
                        etCap.setError(getResources().getString(R.string.obligatorio));

                    if(etCalif.getText().toString().isEmpty())
                        etCalif.setError(getResources().getString(R.string.obligatorio));

                } else {
                    contador++;
                    Log.i(LOGTAG, contador + " " + etTitulo.getText().toString() + seleccion + Integer.parseInt(etAño.getText().toString()) + " " + Integer.parseInt(etTemp.getText().toString()) + " " + Integer.parseInt(etCap.getText().toString()) + " " + Integer.parseInt(etCalif.getText().toString()) + " " + true);
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.guardando), Toast.LENGTH_SHORT).show();
                    anime.setId(contador);
                    anime.setTitulo(etTitulo.getText().toString());
                    anime.setGenero(seleccion);
                    anime.setAño(Integer.parseInt(etAño.getText().toString()));
                    anime.setTemp(Integer.parseInt(etTemp.getText().toString()));
                    anime.setCap(Integer.parseInt(etCap.getText().toString()));
                    anime.setCalif(Integer.parseInt(etCalif.getText().toString()));
                    anime.setLike(true);
                    arrayList.add(anime);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("array",arrayList);
                   bundle.putInt("contador",contador);

                   Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                   intent.putExtras(bundle);
                   startActivity(intent);
                }
                break;

            default:
                break;
        }

    }

}
