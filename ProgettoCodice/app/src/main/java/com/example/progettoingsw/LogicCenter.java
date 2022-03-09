package com.example.progettoingsw;

import android.content.Context;
import android.content.Intent;

import com.example.progettoingsw.ENTITY.Utente;
import com.example.progettoingsw.GUI.homev2.Homev2;

public class LogicCenter {


    //per salvare le informazioni dell'utente creiamo degli attributi
    //statici  in modo da tenere traccia dei cambiamenti di nome password etc
    //direttamente all'interno del centro logico.
    private static String nomesessione;//Da eliminare
    private static String passwordsessione;//da eliminare
    private static Utente utenteloggato;

    //per tenere traccia dell'utente, login.
    public void apriHome(Context activity,Utente user) {

        Intent home = new Intent(activity, Homev2.class);
        activity.startActivity(home);
        utenteloggato= user;

    }

    //dopo una registrazione andata a buon fine loggiamo l'utente all'interno dell'applicazione
    public void registrazione (Context activity, Utente user){
        Intent home = new Intent(activity, Homev2.class);
        activity.startActivity(home);
        utenteloggato= user;
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

    public static Utente getUtenteloggato() {
        return utenteloggato;
    }

    public static void setUtenteloggato(Utente utenteloggato) {
        LogicCenter.utenteloggato = utenteloggato;
    }


}
