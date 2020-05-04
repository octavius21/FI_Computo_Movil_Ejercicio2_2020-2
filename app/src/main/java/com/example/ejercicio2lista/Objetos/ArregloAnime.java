package com.example.ejercicio2lista.Objetos;

import android.content.Context;

import java.io.Serializable;

public class ArregloAnime implements Serializable{
    //ATRIBUTOS
    private Anime[] arreglo;
    private int indice;
    Context context;

    //CONSTRUCTORES
    public ArregloAnime (int max, Context contexto){
        arreglo = new Anime[max];
        indice = -1;
        this.context=contexto;
    }

    //METODOS
    public boolean ValidaEspacio(){
        return (indice < arreglo.length-1);
    }

    public void Insertar (Anime dato, Context contexto){
        this.context=contexto;
        indice++;
        arreglo[indice] = dato;
    }

   public Anime Listar(){
        int i;
        for(i=0; i<=indice; i++)
            return arreglo[i];
        return null;
    }
    public Anime Mostrar(int pos)
    {
       return  arreglo[pos];
    }

    public int getIndice() {

        return indice;
    }
    public Anime[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(Anime[] arreglo) {
        this.arreglo = arreglo;
    }

}
