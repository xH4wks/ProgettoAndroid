package com.example.progettoingsw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.progettoingsw.GUI.*;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button accedi, registrati, indietro;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accedi = (Button) findViewById(R.id.labelBottoneAccedi);
        registrati = (Button) findViewById(R.id.buttonRegistrati);
        indietro = (Button) findViewById(R.id.indietro);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(new LoginFragment());
                registrati.setVisibility(100);
                accedi.setVisibility(100);

            }
        });


        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(new RegistratiFragment());
                registrati.setVisibility(100);
                accedi.setVisibility(100);

            }
        });


        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                closeFragment(new Fragment());

                registrati.setVisibility(0);
                accedi.setVisibility(0);
            }
        });

        //fine on create
    }

    private void getLocation() {

        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {

                @Override

                public void onComplete(@NonNull Task<Location> task) {

                    Location location = task.getResult();
                    if (location != null) {

                        try {

                            Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());

                            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
        }
    }



    private void replaceFragment(Fragment fragment) {

        FragmentManager frman = getSupportFragmentManager();
        FragmentTransaction frtr = frman.beginTransaction();
        frtr.setCustomAnimations(R.anim.entrata_dal_basso,R.anim.esci_dal_basso,R.anim.entrata_dal_basso,R.anim.esci_dal_basso);
        frtr.replace(R.id.fragmentcontainer,fragment);
        frtr.commit();

    }

    private void closeFragment(Fragment fragment) {

        FragmentManager frman = getSupportFragmentManager();
        FragmentTransaction frtr = frman.beginTransaction();
        frtr.setCustomAnimations(R.anim.esci_dal_basso,R.anim.esci_dal_basso);
        frtr.replace(R.id.fragmentcontainer,fragment);
        frtr.commit();

    }

}