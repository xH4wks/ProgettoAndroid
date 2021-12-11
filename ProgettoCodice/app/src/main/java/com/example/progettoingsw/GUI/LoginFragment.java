package com.example.progettoingsw.GUI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.progettoingsw.LogicCenter;
import com.example.progettoingsw.GUI.home.Home;
import com.example.progettoingsw.MainActivity;
import com.example.progettoingsw.R;


public class LoginFragment extends Fragment {

    EditText email,password;
    MainActivity m;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        //component
        Button accesso = (Button) view.findViewById(R.id.buttonaccedi);
        email = (EditText) view.findViewById(R.id.textEmaillogin);
        password = (EditText) view.findViewById(R.id.textPassword);
        accesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LogicCenter l = new LogicCenter();

                if (l.apriHome(email.getText(),password.getText())){
                    Intent home = new Intent(getActivity(),Home.class);
                    startActivity(home);
                }
            }
        });


        //end component
        return  view;
    }



}