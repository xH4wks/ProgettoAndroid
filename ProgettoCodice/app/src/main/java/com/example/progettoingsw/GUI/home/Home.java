package com.example.progettoingsw.GUI.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.progettoingsw.R;

import android.os.Bundle;
import android.widget.Toolbar;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
    }




    // fragment operation
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