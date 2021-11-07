package com.example.natour2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Sign_Up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signinpremuto (View view)
    {
        Intent intent = new Intent(Sign_Up.this, Login.class);
        startActivity(intent);
    }

    public void continuapremuto (View view)
    {
        CheckBox checkbox   = findViewById(R.id.checkBox);

        if (checkbox.isChecked())
            {
                //TODO
            }
        else
            {
                //TODO
            }
    }

    //fine della classe
}