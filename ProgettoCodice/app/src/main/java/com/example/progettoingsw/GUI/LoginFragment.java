package com.example.progettoingsw.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.progettoingsw.ENTITY.Utente;
import com.example.progettoingsw.GUI.homev2.Homev2;
import com.example.progettoingsw.LogicCenter;
import com.example.progettoingsw.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginFragment extends Fragment {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    Button buttonGoogleaccess;

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

        buttonGoogleaccess = (Button) view.findViewById(R.id.buttonGoogleaccess);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this.getActivity(), gso);

        //Qui mantiene l'accesso con l'acc google
        /*GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this.getActivity());
        if(acct!=null){
            navigateToSecondActivity();
        }*/

        buttonGoogleaccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singIn();
            }
        });

        //end component
        return  view;
    }

    void singIn(){
        Intent singInIntent = gsc.getSignInIntent();
        startActivityForResult(singInIntent, 1000);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                e.printStackTrace();
            }

        }
    }

    void navigateToSecondActivity(){
        Intent intent = new Intent(LoginFragment.this.getActivity(), Homev2.class);
        startActivity(intent);
    }

    //richiesta HTTP per l'accesso con la ricezione del file Json con tutte le informazioni dell'utente
    private void  getLoginVolley() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://dev59413.service-now.com/api/887027/natour/login";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //response
                        try {
                            Log.v("ACCESSO",response.getString("username"));
                            //separo gli input per aumentare la leggibilità
                            Utente user = new Utente(response.getString("username"),
                                    response.getString("password"),
                                    response.getString("immagine_profilo"),
                                    response.getString("email"));
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