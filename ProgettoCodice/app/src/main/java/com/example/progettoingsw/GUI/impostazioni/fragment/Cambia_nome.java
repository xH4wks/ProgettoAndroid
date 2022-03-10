package com.example.progettoingsw.GUI.impostazioni.fragment;

import android.content.Context;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cambia_nome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cambia_nome extends Fragment {

    private Button conferma;
    private EditText nuovo_nome,password;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Cambia_nome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cambia_nome.
     */
    // TODO: Rename and change types and number of parameters
    public static Cambia_nome newInstance(String param1, String param2) {
        Cambia_nome fragment = new Cambia_nome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cambia_nome, container, false);
        conferma = (Button) view.findViewById(R.id.impostazioni_cambianome_buttonconferma);
        nuovo_nome = (EditText) view.findViewById(R.id.impostazioni_cambianome_textnuovonome);
        password = (EditText) view.findViewById(R.id.impostazioni_cambianome_textpassword);
        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volleycambianome(password.getText().toString(),nuovo_nome.getText().toString(),getActivity());
            }
        });
        return view;
    }


    //volley
    private static void volleycambianome(String password, String nuovonome, Context activity) {
        String url = "http://140.164.32.230:8080/utente/cambia";
        LogicCenter l = new  LogicCenter();
        Utente user = l.getUtenteloggato();
        if (user.getPassword().equals(password)){
            RequestQueue queue = Volley.newRequestQueue(activity);
            JSONObject params = new JSONObject();
            try {
                params.put("username", nuovonome);
                params.put("password", user.getPassword());
                params.put("email", user.getEmail());
                params.put("immagine_profilo", user.getImmagine_profilo());
            }
            catch (JSONException e){
                Toast.makeText(activity, "errore durante il cambio del nome", Toast.LENGTH_LONG).show();
            }
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            //response
                            try {
                                Utente user = new Utente(response.getString("username"),
                                        response.getString("password"),
                                        response.getString("immagine_profilo"),
                                        response.getString("email"));
                                Toast.makeText(activity, "registrazione avvenuta con successo", Toast.LENGTH_LONG).show();
                                l.apriHome(activity,user);
                            }
                            catch (JSONException e){
                                e.printStackTrace();
                                Toast.makeText(activity, "errore durante il cambio dei dati", Toast.LENGTH_LONG).show();
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(activity, "errore durante il cambio dei dati", Toast.LENGTH_LONG).show();
                        }
                    });

            queue.add(jsonObjectRequest);
        }
        //fine if
        else
            Toast.makeText(activity, "password non corrispondente", Toast.LENGTH_LONG).show();
        //fine metodo

    }



}