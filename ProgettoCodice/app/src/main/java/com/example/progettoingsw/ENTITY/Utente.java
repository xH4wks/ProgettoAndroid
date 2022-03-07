package com.example.progettoingsw.ENTITY;

import android.media.Image;

import com.example.progettoingsw.DAO.UtenteDAO;

public class Utente {

    private String username;
    private String password;
    private String immagine_profilo;
    private String email;


    //costruttore

    public Utente(String username, String password, String immagine_profilo, String email) {
        this.username = username;
        this.password = password;
        this.immagine_profilo = immagine_profilo;
        this.email = email;
    }
    //da eliminare, la sua esistenza è contemplata solo fino al rimpiazzo dei metodi
    // che andranno ad interfaccairsi con il server
    public Utente(String username, String password){}

    //login
    public  boolean login(Utente u){

        UtenteDAO ud = new UtenteDAO();
        boolean result = ud.login(u.username,u.password);

        return  result;
    }

    //registrazione
    public boolean registrati(Utente u) {
        UtenteDAO ud = new UtenteDAO();
        boolean result = ud.registrati(u.username,u.password);

        return  result;
    }

    //cambia nome
    public boolean cambianome(Utente u, String nomesessione) {
        UtenteDAO ud = new UtenteDAO();
        boolean result = ud.cambianome(u.username,u.password,nomesessione);

        return  result;
    }
    //cambia password
    public boolean cambiapassword(Utente u,String nuovapassword) {
        UtenteDAO ud = new UtenteDAO();
        boolean result = ud.cambiapassword(u.username,u.password,nuovapassword);

        return  result;
    }
    //cambia immagine
    public boolean cambiaimmagine(Image i) {
        UtenteDAO ud = new UtenteDAO();
        boolean result = ud.cambiaimmagine(i);

        return  result;
    }




    //setter
    public void setUsername(String username) {
        this.username = username;
    }

    public void setImmagine_profilo(String immagine_profilo) {
        this.immagine_profilo = immagine_profilo;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
