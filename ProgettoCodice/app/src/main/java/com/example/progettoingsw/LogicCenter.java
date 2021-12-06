package com.example.progettoingsw;

import android.content.Intent;
import android.view.View;

import com.example.progettoingsw.ENTITY.Utente;
import com.example.progettoingsw.GUI.home.Home;

public class LogicCenter {


    public boolean apriHome( CharSequence username, CharSequence password) {


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
