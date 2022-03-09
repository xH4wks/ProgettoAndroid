package com.example.progettoingsw.GUI.impostazioni.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.progettoingsw.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cambia_avatar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cambia_avatar extends Fragment {


    private ImageView avatarcorrente,avatar2,avatar3,avatar4,avatar5,avatar6,avatar7;
    private Button conferma;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Cambia_avatar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cambia_avatar.
     */
    // TODO: Rename and change types and number of parameters
    public static Cambia_avatar newInstance(String param1, String param2) {
        Cambia_avatar fragment = new Cambia_avatar();
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
        View view = inflater.inflate(R.layout.fragment_cambia_avatar, container, false);
        avatarcorrente = (ImageView) view.findViewById(R.id.imageView2);
        avatar2 = (ImageView) view.findViewById(R.id.imageView);
        avatar3 = (ImageView) view.findViewById(R.id.imageView3);
        avatar4 = (ImageView) view.findViewById(R.id.imageView4);
        avatar5 = (ImageView) view.findViewById(R.id.imageView5);
        avatar6 = (ImageView) view.findViewById(R.id.imageView6);
        avatar7 = (ImageView) view.findViewById(R.id.imageView7);
        conferma = view.findViewById(R.id.button_cambiaavatarconferma);

        /*
        avatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //scambia(avatarcorrente,avatar2);
            }
        });
        avatar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scambia(avatarcorrente,avatar3);
            }
        });
        avatar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scambia(avatarcorrente,avatar4);
            }
        });
        avatar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scambia(avatarcorrente,avatar5);
            }
        });
        avatar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scambia(avatarcorrente,avatar6);
            }
        });
        avatar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scambia(avatarcorrente,avatar7);
            }
        });
         */
        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"to be implemented", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }


}