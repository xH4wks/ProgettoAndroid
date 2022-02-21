package com.example.progettoingsw.GUI.homev2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.progettoingsw.GUI.impostazioni.Impostazioni;
import com.example.progettoingsw.R;
import com.example.progettoingsw.databinding.ActivityHomev2Binding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class Homev2 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomev2Binding binding;

    //prova suggerimenti ricerca
    private ListView listView;
    String[] name = {"Christopher", "Jenny","Haria", "steve", "Chris","Ivana","Hichael","Craig",
            "Kelly", "Jospeh","Christene", "Sergio", "Mubariz", "Mike", "Alex"};

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityHomev2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHomev2.toolbar);
        binding.appBarHomev2.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.menulaterale_percorsicaricati, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_homev2);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        listView = findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(arrayAdapter);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homev2, menu);

        //azioni aggiunte eliminabili
        //MenuItem menuItem = menu.findItem(R.id.action_search);
        //SearchView searchView = (SearchView) menuItem.getActionView();

        return true;
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.homev2, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        //problema con search view
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Cerca qui");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }*/



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_homev2);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //azioni navbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Intent imp = new Intent(Homev2.this, Impostazioni.class);
                startActivity(imp);

                return true;

            case R.id.menulaterale_percorsicaricati:
                //todo
                return true;

            case R.id.action_search:
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setQueryHint("Cerca qui");

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {

                        arrayAdapter.getFilter().filter(newText);

                        return false;
                    }
                });
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }



    // fragment operation
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