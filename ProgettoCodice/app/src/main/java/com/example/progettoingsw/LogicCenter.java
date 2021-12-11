package com.example.progettoingsw;

import android.content.Intent;
import android.text.Editable;
import android.view.View;

import com.example.progettoingsw.ENTITY.Utente;
import com.example.progettoingsw.GUI.home.Home;

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


}
