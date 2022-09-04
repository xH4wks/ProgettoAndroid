package com.example.progettoingsw.ENTITY;

import android.media.Image;

import java.util.Base64;

public class Fotografia {
    private String proprietario;
    //todo posizionefoto;
    private Base64 image;//valore per passare l'immagine al server e successivamente al db

    public Fotografia(String proprietario, Base64 image) {
        this.proprietario = proprietario;
        this.image = image;
    }
}
