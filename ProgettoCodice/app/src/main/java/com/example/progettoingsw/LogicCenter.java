package com.example.progettoingsw;

import android.content.Context;
import android.content.Intent;
import android.location.Location;

import com.example.progettoingsw.ENTITY.Utente;
import com.example.progettoingsw.GUI.homev2.Homev2;

import java.util.ArrayList;

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


    public ArrayList<Location> caricapercorsi(ArrayList<Location> percorsi) {

        //todo dopo il completamento del backend


    return percorsi;
    }
}
