package com.example.progettoingsw.DAO;

import android.media.Image;

public class UtenteDAO {
    private String url = "https://localhost:8080/";



    public boolean login (String username, String password){
        //todo
        String login = url+"login/";
        return true;
    }

    public boolean registrati(String username, String password) {
        //todo
        return true;
    }

    public boolean cambianome(String username, String password, String nomesessione) {
        //todo
        return true;
    }
    public boolean cambiaimmagine(Image immagine) {
        //todo
        return true;
    }
    public boolean cambiapassword(String username, String password, String nuovapassword) {
        //todo
        return true;
    }
    public String recuperapassword(String username){

        //todo se l'username è presente allora: invia codice altrimenti errore
        inviacodice();

        return null;//todo
    }
    private int inviacodice(){
        int codice=0;
        //todo genera codice per il recupero

        return codice;
    }


}
