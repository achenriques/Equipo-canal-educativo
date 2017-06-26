package com.example.alex.equipo_canal_educativo;

import android.app.Activity;
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

public class Activity2 extends AppCompatActivity {

    private int puntuacion = 0;
    private String aux = "";
    private int actual = 0;
    private boolean silenciado = false;
    long[] vib = {0, 100, 1000};


    private TextView puntos;
    private TextView toShow;
    private ImageButton btTriangulo;
    private ImageButton btCirculo;
    private ImageButton btCuadrado;
    private ImageButton btRectangulo;
    private ImageButton btPentagono;
    private ImageButton btHexagono;
    private Button btSiguiente;

    private SharedPreferences.Editor editor;
    private Vibrator vibrator;// = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


    //Para los sonidos:
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        puntuacion = preferences.getInt("puntuacionFiguras", 0);

        silenciado = false;

        btTriangulo = (ImageButton) findViewById(R.id.a2_triangulo);
        btCirculo = (ImageButton) findViewById(R.id.a2_circulo);
        btCuadrado = (ImageButton) findViewById(R.id.a2_cuadrado);
        btRectangulo = (ImageButton) findViewById(R.id.a2_rectangulo);
        btPentagono = (ImageButton) findViewById(R.id.a2_penta);
        btHexagono = (ImageButton) findViewById(R.id.a2_hexa);
        btSiguiente = (Button) findViewById(R.id.a2_btSig);

        puntos = (TextView) this.findViewById(R.id.a2_puntuacion);
        puntos.setText("Puntuación: " + Integer.toString(puntuacion));

        toShow= (TextView)this.findViewById( R.id.a2_show );

        cambiarMensaje();

        btTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 0)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    siguiente();
                    btTriangulo.setClickable(false);
                    btCirculo.setClickable(false);
                    btCuadrado.setClickable(false);
                    btRectangulo.setClickable(false);
                    btPentagono.setClickable(false);
                    btHexagono.setClickable(false);
                    //Bien bien triangulo
                    mp = MediaPlayer.create(Activity2.this,R.raw.bientriangulo);
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

        btCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 1)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación " + Integer.toString(puntuacion));
                    siguiente();
                    btTriangulo.setClickable(false);
                    btCirculo.setClickable(false);
                    btCuadrado.setClickable(false);
                    btRectangulo.setClickable(false);
                    btPentagono.setClickable(false);
                    btHexagono.setClickable(false);
                    //Bien bien circulo
                    mp = MediaPlayer.create(Activity2.this,R.raw.biencirculo);
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

        btCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 2)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    siguiente();
                    btTriangulo.setClickable(false);
                    btCirculo.setClickable(false);
                    btCuadrado.setClickable(false);
                    btRectangulo.setClickable(false);
                    btPentagono.setClickable(false);
                    btHexagono.setClickable(false);
                    //Bien bien cuadrado
                    mp = MediaPlayer.create(Activity2.this,R.raw.biencuadrado);
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

        btRectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 3)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    siguiente();
                    btTriangulo.setClickable(false);
                    btCirculo.setClickable(false);
                    btCuadrado.setClickable(false);
                    btRectangulo.setClickable(false);
                    btPentagono.setClickable(false);
                    btHexagono.setClickable(false);
                    //Bien bien rectangulo
                    mp = MediaPlayer.create(Activity2.this,R.raw.bienrectangulo);
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

        btPentagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 4)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    siguiente();
                    btTriangulo.setClickable(false);
                    btCirculo.setClickable(false);
                    btCuadrado.setClickable(false);
                    btRectangulo.setClickable(false);
                    btPentagono.setClickable(false);
                    btHexagono.setClickable(false);
                    //Bien bien penta
                    mp = MediaPlayer.create(Activity2.this,R.raw.bienpentagono);
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

        btHexagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual == 5)
                {
                    vibrator.vibrate(50);
                    puntuacion +=10;
                    puntos.setText("Puntuación: " + Integer.toString(puntuacion));
                    siguiente();
                    btTriangulo.setClickable(false);
                    btCirculo.setClickable(false);
                    btCuadrado.setClickable(false);
                    btRectangulo.setClickable(false);
                    btPentagono.setClickable(false);
                    btHexagono.setClickable(false);
                    //Bien bien hexa
                    mp = MediaPlayer.create(Activity2.this,R.raw.bienhexagono);
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
                editor.putInt( "puntuacionFiguras", puntuacion );
                editor.commit();
                //startActivity( new Intent(Activity2.this, Activity2.class));
                cambiarMensaje();
                btTriangulo.setClickable(true);
                btCirculo.setClickable(true);
                btCuadrado.setClickable(true);
                btRectangulo.setClickable(true);
                btPentagono.setClickable(true);
                btHexagono.setClickable(true);
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
        MenuItem it = menu.findItem(R.id.menu_figuras);
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
        editor.putInt( "puntuacionFiguras", puntuacion );
        editor.commit();


        boolean toret = false;
        switch( menuItem.getItemId() ) {
            /*case R.id.menu_figuras:
                Activity2.this.startActivityForResult( new Intent(Activity2.this, Activity2.class), REQUEST_CODE);
                toret = true;
                break;*/
            case R.id.menu_dibujos:
                startActivity( new Intent(Activity2.this, Activity3.class));
                toret = true;
                break;
            case R.id.menu_mates:
                startActivity( new Intent(Activity2.this, Activity4.class));
                toret = true;
                break;
            case R.id.menu_volver:
                MainActivity.firstTime = false; //Para q no muestre pantalla de bienvenida
                startActivity( new Intent(Activity2.this, MainActivity.class));
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
                editor.remove("puntuacionFiguras").commit();
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

        String[] array = getResources().getStringArray(R.array.figuras);
        try {
            actual = randomGenerator();
            aux = array[actual];
            toShow.setText(array[actual]);
        }catch (NullPointerException exc){
            Toast.makeText( this.getApplicationContext(), "Rompe en array de figuras.", Toast.LENGTH_SHORT ).show();
        }
    }

    public void reproucirMal ()
    {
        switch (actual) {
            case 0:
                vibrator.vibrate(vib , 2);
                mp = MediaPlayer.create(Activity2.this, R.raw.maltriangulo);
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
                mp = MediaPlayer.create(Activity2.this, R.raw.malcirculo);
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
                mp = MediaPlayer.create(Activity2.this, R.raw.malcuadrado);
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
                mp = MediaPlayer.create(Activity2.this, R.raw.malrectangulo);
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
                mp = MediaPlayer.create(Activity2.this, R.raw.malpentagono);
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
                mp = MediaPlayer.create(Activity2.this, R.raw.malhexagono);
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
        Toast.makeText(Activity2.this, "Pulsa siguiente para seguir jugando", Toast.LENGTH_SHORT).show();
    }
}

