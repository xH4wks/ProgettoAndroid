package com.example.progettoingsw;

import android.text.Editable;

import com.example.progettoingsw.ENTITY.Utente;

public class LogicCenter {


    //per salvare le informazioni dell'utente creiamo degli attributi
    //statici  in modo da tenere traccia dei cambiamenti di nome password etc
    //direttamente all'interno del centro logico.
    private static String nomesessione;
    private static String passwordsessione;


    public boolean apriHome(String username, String password) {


        Utente u = new Utente(username,password);
        if (u.login(u)){
            setNomesessione(username);
            setPasswordsessione(password);
            return true;
        }

        else {
            //todo
            return false;
        }


    }

    public boolean registrazione (String username, String password){

        Utente u = new Utente(username,password);
        if(u.registrati(u)){
            return  true;
        }
        else{
            //todo
            return  false;
        }

    }


    public void cambianome(Editable nuovonome, Editable password) {
        //todo non ho ancora idea di come salvare le informazioni dell'utente
        //all'interno dell' app
    }

    //getter and setter
    public static String getNomesessione() {
        return nomesessione;
    }

    public static void setNomesessione(String nomesessione) {
        LogicCenter.nomesessione = nomesessione;
    }

    public static String getPasswordsessione() {
        return passwordsessione;
    }

    public static void setPasswordsessione(String passwordsessione) {
        LogicCenter.passwordsessione = passwordsessione;
    }

}
