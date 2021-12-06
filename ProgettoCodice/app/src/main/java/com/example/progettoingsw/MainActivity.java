package com.example.progettoingsw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.progettoingsw.GUI.*;

public class MainActivity extends AppCompatActivity {

    Button accedi,registrati, indietro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accedi = (Button) findViewById(R.id.labelBottoneAccedi);
        registrati = (Button)findViewById(R.id.buttonRegistrati);
        indietro = (Button) findViewById(R.id.indietro);


        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(new LoginFragment());
                registrati.setVisibility(100);
                accedi.setVisibility(100);

            }
        });


        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(new RegistratiFragment());
                registrati.setVisibility(100);
                accedi.setVisibility(100);

            }
        });


        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                closeFragment(new Fragment());

                registrati.setVisibility(0);
                accedi.setVisibility(0);
            }
        });

        //fine on create
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager frman = getSupportFragmentManager();
        FragmentTransaction frtr = frman.beginTransaction();
        frtr.setCustomAnimations(R.anim.entrata_dal_basso,R.anim.esci_dal_basso,R.anim.entrata_dal_basso,R.anim.esci_dal_basso);
        frtr.replace(R.id.fragmentcontainer,fragment);
        frtr.commit();

    }

    private void closeFragment(Fragment fragment) {

        FragmentManager frman = getSupportFragmentManager();
        FragmentTransaction frtr = frman.beginTransaction();
        frtr.setCustomAnimations(R.anim.esci_dal_basso,R.anim.esci_dal_basso);
        frtr.replace(R.id.fragmentcontainer,fragment);
        frtr.commit();

    }

}