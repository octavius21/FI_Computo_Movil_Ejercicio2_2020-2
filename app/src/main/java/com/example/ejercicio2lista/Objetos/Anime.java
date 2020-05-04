package com.example.ejercicio2lista.Objetos;

import android.content.Context;
import android.util.Log;

import java.io.Serializable;

public class Anime implements Serializable{
    private static final String LOGTAG="Anime";
    int id;
    String titulo;
    String genero;
    int año;
    int temp;
    int cap;
    int calif;
    Boolean like;
    Context context;

    public boolean validarDatos(String titulo,int año,int temp,int cap,int calif,Boolean like){
        Log.i(LOGTAG, id+" "+titulo+"  "+año+" "+temp+" "+cap+" "+calif+" "+like);
        if(-1==id||null==titulo||-1==año||-1==temp||-1==cap||-1==calif||null==like)
            return false;
        else
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public int getCalif() {
        return calif;
    }

    public void setCalif(int calif) {
        this.calif = calif;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }


}
