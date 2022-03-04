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

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.progettoingsw.GUI.homev2.Homev2;
import com.example.progettoingsw.LogicCenter;
import com.example.progettoingsw.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;


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
    public void getLoginVolley(){

// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        Log.v("ACCESSO", email.getText().toString());
        Log.v("ACCESSO", password.getText().toString());

        String url = "http://10.181.94.110:8080/login/"+email.getText().toString()+"/" +password.getText().toString();
        Log.v("ACCESSO", url);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Toast.makeText(getActivity(), "accesso eseguito", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"accesso esploso",Toast.LENGTH_SHORT).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    /*public void  getLoginVolley() {

        try {
            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("username", "Shozib@gmail.com");
            jsonBody.put("password", "Shozib123");
            jsonBody.put("email","mailacaso@caso.org");
            jsonBody.put("immagine_profilo","icons8_rick_sanchez_100");
            final String mRequestBody = jsonBody.toString();
            String URL = "http://10.181.94.110:8080/login";

            StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("LOG_RESPONSE", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("LOG_RESPONSE", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/


}