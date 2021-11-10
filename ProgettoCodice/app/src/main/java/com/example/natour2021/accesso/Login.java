package com.example.natour2021.accesso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.natour2021.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    //apre l'activity per la registrazione
    public void signuppremuto(View view)
    {
        Intent intent = new Intent(Login.this, Registrazione.class);
        startActivity(intent);
    }
    //apre l'activity per il recupero della password
    public void passworddimenticatapremuto (View view)
    {
        //TODO
    }
    //apre l'activity principale dell'app
    public void signinpremuto (View view)
    {
        //TODO
    }
    //apre esegue l'accesso con google
    public void googleaccesspremuto (View view)
    {
        //TODO
    }
    //apre esegue l'accesso con facebook
    public void facebookaccespremuto (View view)
    {
        //TODO
    }

//fine della classe
}