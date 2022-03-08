package com.example.progettoingsw.GUI;

import android.os.Bundle;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.progettoingsw.ENTITY.Utente;
import com.example.progettoingsw.LogicCenter;
import com.example.progettoingsw.R;

import org.json.JSONException;
import org.json.JSONObject;


public class RegistratiFragment extends Fragment {

    Button continua;
    EditText email, password, conferma_ps,username;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_registrati, container, false);
        email = (EditText) view.findViewById(R.id.Registrati_textEmail);
        password = (EditText)  view.findViewById(R.id.Registrati_textPassword);
        conferma_ps = (EditText)  view.findViewById(R.id.Registrati_textConfermapss);
        username= (EditText)  view.findViewById(R.id.Registrati_textusername);
        continua = view.findViewById(R.id.Registrati_buttonContinua);
        continua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogicCenter l = new LogicCenter();
                if (password.getText().toString().equals(conferma_ps.getText().toString())){
                postRegistrazioneVolley();
                }
                else {
                    //todo visualizza label errore
                    Toast.makeText(getActivity(), "errore, password non corrispondenti", Toast.LENGTH_LONG).show();
                }

            }
        });



        return view;
    }
    //chiamate volley
    //richiesta HTTP per la registrazione con invio del file Json con tutte le informazioni dell'utente
    public void  postRegistrazioneVolley() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "http://192.168.1.3:8080/registrati"  ;
        JSONObject params = new JSONObject();
        try {
            params.put("username", username.getText().toString());
            params.put("password", password.getText().toString());
            params.put("email", email.getText().toString());
            params.put("immagine_profilo", "icons8_rick_sanchez_100");
        }
        catch (JSONException e){
            Toast.makeText(getActivity(), "errore durante la registrazione dell'utente, riprovare più tardi", Toast.LENGTH_LONG).show();
        }


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //response
                        LogicCenter l = new LogicCenter();
                        try {
                            Utente user = new Utente(response.getString("username"),
                                    response.getString("password"),
                                    response.getString("immagine_profilo"),
                                    response.getString("email"));
                            l.registrazione(getActivity(),user);
                            Toast.makeText(getActivity(), "registrazione avvenuta con successo, accesso in corso...", Toast.LENGTH_LONG).show();
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "errore durante la registrazione dell'utente, riprovare più tardi", Toast.LENGTH_LONG).show();
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