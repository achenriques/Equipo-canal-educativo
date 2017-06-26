package com.example.alex.equipo_canal_educativo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.R.drawable.ic_lock_silent_mode;
import static android.R.drawable.ic_lock_silent_mode_off;

/**
 * Created by Alex on 08/11/2016.
 */

public class Activity3 extends AppCompatActivity {

    private int puntuacion = 0;
    private String aux = "";
    private int actual = 0;
    private boolean silenciado = false;
    long[] vib = {0, 100, 500};

    private TextView puntos;
    private TextView toShow;
    private ImageButton btArbol;
    private ImageButton btCasa;
    private ImageButton btCoche;
    private ImageButton btBus;
    private ImageButton btBarco;
    private ImageButton btAvion;
    private Button btSiguiente;

    private SharedPreferences.Editor editor;
    private Vibrator vibrator;// = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

    //Para los sonidos:
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_main);

        vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        puntuacion = preferences.getInt("puntuacionDibujos", 0);

        silenciado = false;

        btArbol = (ImageButton) findViewById(R.id.a3_arbol);
        btCasa = (ImageButton) findViewById(R.id.a3_casa);
        btCoche = (ImageButton) findViewById(R.id.a3_coche);
        btBus = (ImageButton) findViewById(R.id.a3_bus);
        btBarco = (ImageButton) findViewById(R.id.a3_barco);
        btAvion = (ImageButton) findViewById(R.id.a3_avion);
        btSiguiente = (Button) findViewById(R.id.a3_btSig);



        puntos = (TextView) this.findViewById(R.id.a3_puntuacion);
        puntos.setText("Puntuación: " + Integer.toString(puntuacion));

        toShow= (TextView)this.findViewById( R.id.a3_show );

        cambiarMensaje();

        btArbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 0)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    siguiente();
                    btArbol.setClickable(false);
                    btCasa.setClickable(false);
                    btCoche.setClickable(false);
                    btBus.setClickable(false);
                    btBarco.setClickable(false);
                    btAvion.setClickable(false);
                    //Bien bien triangulo
                    mp = MediaPlayer.create(Activity3.this,R.raw.bienarbol);
                    mp.setLooping(false);
                    if(!silenciado)
                    {
                        mp.setVolume(100, 100);
                    }
                    else
                    {
                        mp.setVolume(0, 0);
                    }
                    mp.start();
                }
                else{
                    reproucirMal();
                }
            }
        });

        btCasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 1)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    siguiente();
                    btArbol.setClickable(false);
                    btCasa.setClickable(false);
                    btCoche.setClickable(false);
                    btBus.setClickable(false);
                    btBarco.setClickable(false);
                    btAvion.setClickable(false);
                    //Bien bien circulo
                    mp = MediaPlayer.create(Activity3.this,R.raw.biencasa);
                    mp.setLooping(false);
                    if(!silenciado)
                    {
                        mp.setVolume(100, 100);
                    }
                    else
                    {
                        mp.setVolume(0, 0);
                    }
                    mp.start();
                }
                else{
                    reproucirMal();
                }
            }
        });

        btCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 2)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    siguiente();
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    btArbol.setClickable(false);
                    btCasa.setClickable(false);
                    btCoche.setClickable(false);
                    btBus.setClickable(false);
                    btBarco.setClickable(false);
                    btAvion.setClickable(false);
                    //Bien bien cuadrado
                    mp = MediaPlayer.create(Activity3.this,R.raw.biencoche);
                    mp.setLooping(false);
                    if(!silenciado)
                    {
                        mp.setVolume(100, 100);
                    }
                    else
                    {
                        mp.setVolume(0, 0);
                    }
                    mp.start();
                }
                else{
                    reproucirMal();
                }
            }
        });

        btBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 3)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    siguiente();
                    btArbol.setClickable(false);
                    btCasa.setClickable(false);
                    btCoche.setClickable(false);
                    btBus.setClickable(false);
                    btBarco.setClickable(false);
                    btAvion.setClickable(false);
                    //Bien bien rectangulo
                    mp = MediaPlayer.create(Activity3.this,R.raw.bienautobus);
                    mp.setLooping(false);
                    if(!silenciado)
                    {
                        mp.setVolume(100, 100);
                    }
                    else
                    {
                        mp.setVolume(0, 0);
                    }
                    mp.start();
                }
                else{
                    reproucirMal();
                }
            }
        });

        btBarco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 4)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    siguiente();
                    btArbol.setClickable(false);
                    btCasa.setClickable(false);
                    btCoche.setClickable(false);
                    btBus.setClickable(false);
                    btBarco.setClickable(false);
                    btAvion.setClickable(false);
                    //Bien bien penta
                    mp = MediaPlayer.create(Activity3.this,R.raw.bienbarco);
                    mp.setLooping(false);
                    if(!silenciado)
                    {
                        mp.setVolume(100, 100);
                    }
                    else
                    {
                        mp.setVolume(0, 0);
                    }
                    mp.start();
                }
                else{
                    reproucirMal();
                }
            }
        });

        btAvion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 5)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    siguiente();
                    btArbol.setClickable(false);
                    btCasa.setClickable(false);
                    btCoche.setClickable(false);
                    btBus.setClickable(false);
                    btBarco.setClickable(false);
                    btAvion.setClickable(false);
                    //Bien bien hexa
                    mp = MediaPlayer.create(Activity3.this,R.raw.bienavion);
                    mp.setLooping(false);
                    if(!silenciado)
                    {
                        mp.setVolume(100, 100);
                    }
                    else
                    {
                        mp.setVolume(0, 0);
                    }
                    mp.start();
                }
                else{
                    reproucirMal();
                }
            }
        });

        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt( "puntuacionDibujos", puntuacion );
                editor.apply();
                //startActivity( new Intent(Activity3.this, Activity3.class));
                cambiarMensaje();
                btArbol.setClickable(true);
                btCasa.setClickable(true);
                btCoche.setClickable(true);
                btBus.setClickable(true);
                btBarco.setClickable(true);
                btAvion.setClickable(true);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
            Toast.makeText(getApplicationContext(), "Utilice el menú de la aplicación, por favor",
                    Toast.LENGTH_LONG).show();

        return false;
        // Disable back button..............
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate( R.menu.main_menu, menu );
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem it = menu.findItem(R.id.menu_dibujos);
        it.setVisible(false);

        it = menu.findItem(R.id.menu_silencio);
        if(!silenciado)
        {
            it.setTitle("Silenciar");
            it.setIcon(getResources().getDrawable(ic_lock_silent_mode));
        }
        else
        {
            it.setTitle("Activar sonido");
            it.setIcon(getResources().getDrawable(ic_lock_silent_mode_off));
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        editor.putInt( "puntuacionDibujos", puntuacion );
        editor.apply();


        boolean toret = false;
        switch( menuItem.getItemId() ) {
            case R.id.menu_figuras:
                startActivity( new Intent(Activity3.this, Activity2.class));
                toret = true;
                break;
            /*case R.id.menu_dibujos:
                startActivity( new Intent(Activity3.this, Activity3.class));
                toret = true;
                break;*/
            case R.id.menu_mates:
                startActivity( new Intent(Activity3.this, Activity4.class));
                toret = true;
                break;
            case R.id.menu_volver:
                MainActivity.firstTime = false; //Para q no muestre pantalla de bienvenida
                startActivity( new Intent(Activity3.this, MainActivity.class));
                toret = true;
                break;
            case R.id.menu_silencio:
                if(!silenciado)
                {
                    mp.setVolume(0, 0);
                    silenciado = true;
                }
                else
                {
                    mp.setVolume(100, 100);
                    silenciado = false;
                }
                toret = true;
                break;
            case R.id.menu_punt:
                editor.remove("puntuacionDibujos");
                if(editor.commit()) {
                    puntuacion = 0;
                    puntos.setText("Puntuación: 0");
                }
                toret = true;
                break;
        }
        return toret;
    }

    public int randomGenerator()
    {
        Random toret = new Random();
        return toret.nextInt(5);
    }

    public void cambiarMensaje(){

        String[] array = getResources().getStringArray(R.array.dibujos);
        //try {
            actual = randomGenerator();
            aux = array[actual];
            toShow.setText(array[actual]);
        //}catch (NullPointerException exc){
            //Toast.makeText( this.getApplicationContext(), "Rompe en array de dibujos.", Toast.LENGTH_SHORT ).show();
        //}
    }

    public void reproucirMal ()
    {
        switch (actual) {
            case 0:
                vibrator.vibrate(vib , 5);
                mp = MediaPlayer.create(Activity3.this, R.raw.malarbol);
                mp.setLooping(false);
                if(!silenciado)
                {
                    mp.setVolume(100, 100);
                }
                else
                {
                    mp.setVolume(0, 0);
                }
                mp.start();
                break;

            case 1:
                vibrator.vibrate(vib , 2);
                mp = MediaPlayer.create(Activity3.this, R.raw.malcasa);
                mp.setLooping(false);
                if(!silenciado)
                {
                    mp.setVolume(100, 100);
                }
                else
                {
                    mp.setVolume(0, 0);
                }
                mp.start();
                break;

            case 2:
                vibrator.vibrate(vib , 2);
                mp = MediaPlayer.create(Activity3.this, R.raw.malcoche);
                mp.setLooping(false);
                if(!silenciado)
                {
                    mp.setVolume(100, 100);
                }
                else
                {
                    mp.setVolume(0, 0);
                }
                mp.start();
                break;

            case 3:
                vibrator.vibrate(vib , 2);
                mp = MediaPlayer.create(Activity3.this, R.raw.malautobus);
                mp.setLooping(false);
                if(!silenciado)
                {
                    mp.setVolume(100, 100);
                }
                else
                {
                    mp.setVolume(0, 0);
                }
                mp.start();
                break;

            case 4:
                vibrator.vibrate(vib , 2);
                mp = MediaPlayer.create(Activity3.this, R.raw.malbarco);
                mp.setLooping(false);
                if(!silenciado)
                {
                    mp.setVolume(100, 100);
                }
                else
                {
                    mp.setVolume(0, 0);
                }
                mp.start();
                break;

            case 5:
                vibrator.vibrate(vib , 2);
                mp = MediaPlayer.create(Activity3.this, R.raw.malavion);
                mp.setLooping(false);
                if(!silenciado)
                {
                    mp.setVolume(100, 100);
                }
                else
                {
                    mp.setVolume(0, 0);
                }
                mp.start();
                break;

        }
    }

    public void siguiente()
    {
        Toast.makeText(Activity3.this, "Pulsa siguiente para seguir jugando", Toast.LENGTH_SHORT).show();
    }

}