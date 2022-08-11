package com.example.progettoingsw.GUI;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.progettoingsw.ENTITY.Utente;
import com.example.progettoingsw.LogicCenter;
import com.example.progettoingsw.R;

import org.json.JSONException;
import org.json.JSONObject;


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
                getLoginVolley();
            }
        });


        //todo accesso google e facebook

        //end component
        return  view;
    }

    //richiesta HTTP per l'accesso con la ricezione del file Json con tutte le informazioni dell'utente
    private void  getLoginVolley() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "http://140.164.32.230:8080/" +"login/"+email.getText().toString()+"/"+password.getText().toString() ;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //response
                        try {
                            JSONObject risposta = response.getJSONObject("result");
                            Log.v("ACCESSO",response.getString("username"));
                            //separo gli input per aumentare la leggibilità
                            Utente user = new Utente(risposta.getString("username"),
                                    risposta.getString("password"),
                                    risposta.getString("immagine_profilo"),
                                    risposta.getString("email"));
                            LogicCenter l = new LogicCenter();
                            l.apriHome(getActivity(),user);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        queue.add(jsonObjectRequest);
    }


}