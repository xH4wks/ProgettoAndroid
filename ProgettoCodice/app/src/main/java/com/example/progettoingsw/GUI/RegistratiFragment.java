package com.example.progettoingsw.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.progettoingsw.GUI.homev2.Homev2;
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
        email = (EditText) view.findViewById(R.id.Registrati_textEmail);
        password = (EditText)  view.findViewById(R.id.Registrati_textPassword);
        conferma_ps = (EditText)  view.findViewById(R.id.Registrati_textConfermapss);
        continua = view.findViewById(R.id.Registrati_buttonContinua);
        continua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogicCenter l = new LogicCenter();
                if (password.getText().toString().equals(conferma_ps.getText().toString())){

                    if (l.registrazione(email.getText().toString(),password.getText().toString())){
                        Intent home = new Intent(getActivity(), Homev2.class);
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