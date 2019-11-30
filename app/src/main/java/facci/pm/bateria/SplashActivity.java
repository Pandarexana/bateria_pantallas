package facci.pm.bateria;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    //Constante de tipo entero que representa el tiempo en
    // milisegundos que se muestra nuestra actividad al usuario.
    static int TIMEOUT_MILLIS = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asigna el archivo XML que va a ligarse como diseño de la pantalla
        setContentView(R.layout.activity_splash);
        //Quitamos la action bar de la pantalla Splash
        getSupportActionBar().hide();
        //La clase Handler permite enviar objetos de tipo Runnable.
        //Un objeto de tipo runnable da el significado a un hilo de proceso
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent es la definición abstracta de una operación a realizar.
                //Puede ser usado para una activity, broadcast receiver, servicios.
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                //Finaliza esta activity
                finish();
            }
        }, TIMEOUT_MILLIS);
    }
}
