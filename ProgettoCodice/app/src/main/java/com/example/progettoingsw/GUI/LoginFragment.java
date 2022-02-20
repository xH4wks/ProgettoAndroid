package com.example.progettoingsw.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.progettoingsw.GUI.homev2.Homev2;
import com.example.progettoingsw.LogicCenter;
import com.example.progettoingsw.R;


public class LoginFragment extends Fragment {

    EditText email,password;



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
        password = (EditText) view.findViewById(R.id.Registrati_textPassword);
        accesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LogicCenter l = new LogicCenter();

                if (l.apriHome(email.getText().toString(),password.getText().toString())){
                    getLoginVolley();
                    Intent home = new Intent(getActivity(), Homev2.class);
                    startActivity(home);
                }
            }
        });
        //todo accesso google e facebook

        //end component
        return  view;
    }

    public void  getLoginVolley() {

// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url =  "http://localhost:8080/login";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("erroreHTTP",error.toString());
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}