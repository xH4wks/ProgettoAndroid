package com.example.progettoingsw;

import android.text.Editable;

import com.example.progettoingsw.ENTITY.Utente;

public class LogicCenter {


    public boolean apriHome(Editable username, Editable password) {


        Utente u = new Utente(username.toString(),password.toString());
        if (u.login(u)){
            return true;
        }

        else {
            //todo
            return false;
        }


    }

    public boolean registrazione (Editable username, Editable password){

        Utente u = new Utente(username.toString(),password.toString());
        if(u.registrati(u)){
            return  true;
        }
        else{
            //todo
            return  false;
        }

    }


    public void cambiapassword(Editable nuovonome, Editable password) {
        //todo non ho ancora idea di come salvare le informazioni dell'utente
        //all'interno dell' app
    }
}
