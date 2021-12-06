package com.example.progettoingsw.GUI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.progettoingsw.LogicCenter;
import com.example.progettoingsw.GUI.home.Home;
import com.example.progettoingsw.R;


public class LoginFragment extends Fragment implements View.OnClickListener {




    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        //component
        Button accesso = (Button) view.findViewById(R.id.buttonaccedi);
        accesso.setOnClickListener(this);

        //end component
        return  view;
    }
    @Override
    public void onClick(View v) {

        TextView email =(TextView) v.findViewById(R.id.textEmail);
        TextView password =(TextView) v.findViewById(R.id.textPassword);
        LogicCenter f = new LogicCenter();
        boolean result;
        result = f.apriHome(email.getText(),password.getText());
        if (result){
            Intent home = new Intent(getActivity(), Home.class);
            startActivity(home);
        }


        }


}