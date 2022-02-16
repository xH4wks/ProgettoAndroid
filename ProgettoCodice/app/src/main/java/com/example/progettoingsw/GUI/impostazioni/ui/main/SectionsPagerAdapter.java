package com.example.progettoingsw.GUI.impostazioni.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.progettoingsw.GUI.impostazioni.fragment.Cambia_avatar;
import com.example.progettoingsw.GUI.impostazioni.fragment.Cambia_nome;
import com.example.progettoingsw.GUI.impostazioni.fragment.Cambia_password;
import com.example.progettoingsw.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
    Fragment fragment = null;
    switch (position){
        case 0:
            fragment = Cambia_nome.newInstance(null,null);
            break;
        case 1:
            fragment = Cambia_password.newInstance(null,null);
            break;
        case 2:
            fragment = Cambia_avatar.newInstance(null,null);
            break;
    }
    return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
               return "cambia nome";
            case 1:
                return "cambia password";
            case 2:
                return "cambia avatar";
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}