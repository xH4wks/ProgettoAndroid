package controllore;
import android.content.Intent;

import  gui.accesso.*;

public class Controllore {

    public static void  main (String Args[])
    {
        Login log = new Login();
        log.setVisible(true);

    }

    // bottone registrazione premuto nella gui
    public void apriregistrazione(Login log)
    {
        Intent intent = new Intent(log, Registrazione.class);
        log.startActivity(intent);
    }

    // bottone accedi premuto nella gui
    public  void aprilogin(Registrazione reg)
    {
        Intent intent = new Intent(reg, Login.class);
        reg.startActivity(intent);
    }
}
