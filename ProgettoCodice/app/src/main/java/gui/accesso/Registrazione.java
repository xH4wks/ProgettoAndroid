package gui.accesso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.natour2021.R;

import controllore.Controllore;


public class Registrazione extends AppCompatActivity {

    Controllore ctrl;

    public Registrazione() {
        ctrl = new Controllore();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);
    }

    //bottone per tornare al login
    public void signinpremuto (){
        ctrl.aprilogin(this);
    }
}