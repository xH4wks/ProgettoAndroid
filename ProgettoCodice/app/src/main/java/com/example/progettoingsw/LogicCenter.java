package com.example.progettoingsw;

import android.text.Editable;

import com.example.progettoingsw.ENTITY.Utente;

public class LogicCenter {

    //per salvare le informazioni dell'utente creiamo degli attributi
    //statici  in modo da tenere traccia dei cambiamenti di nome password etc
    //direttamente all'interno del centro logico.


    public boolean apriHome(String username, String password) {


        Utente u = new Utente(username,password);
        if (u.login(u)){

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
}
