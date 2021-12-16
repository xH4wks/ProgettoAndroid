package com.example.progettoingsw.GUI.impostazioni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;

import com.example.progettoingsw.R;

public class Impostazioni extends AppCompatActivity {

    private FragmentContainerView avatar,nome,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        avatar = (FragmentContainerView) findViewById(R.id.impostazioni_containercambiaavatar);
        nome = (FragmentContainerView) findViewById(R.id.impostazioni_containercambianomeutente);
        password = (FragmentContainerView) findViewById(R.id.impostazioni_containercambiacambiapassword);

        //fine on create
        setContentView(R.layout.activity_impostazioni);
    }

    public void espandi (int fragment){
       //TODO
        switch (fragment){

            case (1):
                avatar.setMinimumHeight(350);
                break;

            case (2):
                nome.setMinimumHeight(300);
                break;
            case (3):
                password.setMinimumHeight(300);
                break;

        }
    //fine espandi
    }

    public void comprimi (int fragment){
        //TODO
        switch (fragment){
            case (1):
                avatar.setMinimumHeight(100);
                break;
            case (2):
                nome.setMinimumHeight(100);
                break;
            case (3):
                password.setMinimumHeight(100);
                break;
        }
    //fine comprimi
    }

}