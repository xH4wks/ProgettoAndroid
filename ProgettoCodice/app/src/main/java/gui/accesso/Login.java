package gui.accesso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.natour2021.R;

import controllore.Controllore;


public class Login extends AppCompatActivity {

    Controllore ctrl;

    public Login() {
        ctrl = new Controllore();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    //apre l'activity per la registrazione
    public void signuppremuto()
    {
        ctrl.apriregistrazione(this);
    }
    //apre l'activity per il recupero della password
    public void passworddimenticatapremuto ()
    {
        //TODO
    }
    //apre l'activity principale dell'app
    public void signinpremuto ()
    {
        //TODO
    }
    //apre esegue l'accesso con google
    public void googleaccesspremuto ()
    {
        //TODO
    }
    //apre esegue l'accesso con facebook
    public void facebookaccespremuto ()
    {
        //TODO
    }

//fine della classe
}