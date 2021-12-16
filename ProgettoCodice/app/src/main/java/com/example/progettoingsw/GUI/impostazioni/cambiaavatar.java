package com.example.progettoingsw.GUI.impostazioni;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.progettoingsw.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cambiaavatar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cambiaavatar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final int  ID = 1;
    private Button espandi;
    private  boolean aperto = false;
    private  Impostazioni imp;

    public cambiaavatar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cambiaavatar.
     */
    // TODO: Rename and change types and number of parameters
    public static cambiaavatar newInstance(String param1, String param2) {
        cambiaavatar fragment = new cambiaavatar();
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
        View v = inflater.inflate(R.layout.fragment_cambiaavatar, container, false);
        espandi = (Button) v.findViewById(R.id.avatar_bottoneespandi);
        espandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (aperto){
                    imp.comprimi(ID);
                }
                else {
                    imp.espandi(ID);
                }
            }
        });
        return v;
    }
}