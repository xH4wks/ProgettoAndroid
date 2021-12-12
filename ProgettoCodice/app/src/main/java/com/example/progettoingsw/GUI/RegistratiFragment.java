package com.example.progettoingsw.GUI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.progettoingsw.GUI.home.Home;
import com.example.progettoingsw.LogicCenter;
import com.example.progettoingsw.R;


public class RegistratiFragment extends Fragment {

    Button continua;
    EditText email, password, conferma_ps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_registrati, container, false);

        continua = view.findViewById(R.id.buttonContinua);
        continua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogicCenter l = new LogicCenter();
                email = view.findViewById(R.id.textEmail);
                password = view.findViewById(R.id.textPassword);
                conferma_ps = view.findViewById(R.id.textConferma);

                if (password.toString().equals(conferma_ps.toString())){

                    if (l.registrazione(email.getText(),password.getText())){
                        Intent home = new Intent(getActivity(), Home.class);
                        startActivity(home);
                    }
                    else {
                        // todo visualizza pop up errore durante la registrazione
                    }


                }
                else {
                    //todo visualizza label errore
                }

            }
        });



        return view;
    }
}