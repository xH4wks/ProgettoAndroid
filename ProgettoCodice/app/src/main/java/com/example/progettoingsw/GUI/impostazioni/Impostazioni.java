package com.example.progettoingsw.GUI.impostazioni;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.progettoingsw.GUI.impostazioni.ui.main.SectionsPagerAdapter;
import com.example.progettoingsw.databinding.ActivityImpostazioniBinding;
import com.google.android.material.tabs.TabLayout;

public class Impostazioni extends AppCompatActivity {

    private ActivityImpostazioniBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityImpostazioniBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}