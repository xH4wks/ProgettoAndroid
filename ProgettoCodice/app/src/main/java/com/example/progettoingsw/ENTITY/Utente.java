package com.example.progettoingsw.ENTITY;

import android.media.Image;

import com.example.progettoingsw.DAO.UtenteDAO;

public class Utente {

    private String username;
    private  String password;
    private Image immagine_profilo;
    // variabile per la posizione todo

    //costruttore per login
    public Utente(String Username, String Password){
        this.username=Username;
        this.password=Password;
    }

    //login
    public  boolean login(Utente u){

        UtenteDAO ud = new UtenteDAO();
        boolean result = ud.login(u.username,u.password);

        return  result;
    }


    //setter
    public void setUsername(String username) {
        this.username = username;
    }

    public void setImmagine_profilo(Image immagine_profilo) {
        this.immagine_profilo = immagine_profilo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
