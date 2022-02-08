package com.example.progettoingsw;

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


    public boolean cambianome(String nuovonome, String password) {
        Utente u = new Utente(nuovonome,password);
        if(u.cambianome(u,nomesessione)){
            setNomesessione(nuovonome);
            return  true;
        }
        else{
            //todo
            return  false;
        }

    }
    public boolean cambipassword(String nuovapassword, String vecchiapassword) {
        Utente u = new Utente(nomesessione,nuovapassword);
        if(u.cambiapassword(u,vecchiapassword)){
            setPasswordsessione(nuovapassword);
            return  true;
        }
        else{
            //todo
            return  false;
        }
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
