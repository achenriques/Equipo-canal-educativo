package com.example.alex.equipo_canal_educativo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static int REQUEST_1 = 1;

    public static boolean firstTime = true;

    private SharedPreferences prefs;
    private int puntosFiguras = 0;
    private int puntosDibujos = 0;
    private int puntosMates = 0;

    private final TextView punt1 = null;
    private final TextView punt2 = null;
    private TextView punt3 = null;

    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        puntosFiguras = preferences.getInt("puntuacionFiguras", 0);
        puntosDibujos = preferences.getInt("puntuacionDibujos", 0);
        puntosMates = preferences.getInt("puntuacionMates", 0);

        final TextView punt1 = (TextView) this.findViewById(R.id.ap_punt1);
        final TextView punt2 = (TextView) this.findViewById(R.id.ap_punt2);
        final TextView punt3 = (TextView) this.findViewById(R.id.ap_punt3);

        final Button btFiguras = (Button) this.findViewById(R.id.ap_btFiguras);
        final Button btDibujos = (Button) this.findViewById(R.id.ap_btDibujos);
        final Button btMates = (Button) this.findViewById(R.id.ap_btMates);

        punt1.setText(Integer.toString(puntosFiguras));
        punt2.setText(Integer.toString(puntosDibujos));
        punt3.setText(Integer.toString(puntosMates));

        btFiguras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Activity2.class));
            }
        });

        btDibujos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Activity3.class));
            }
        });

        btMates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Activity4.class));
            }

        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
            MainActivity.this.finish();

        return true;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        if(firstTime) {
            startActivityForResult(new Intent(MainActivity.this, InitActivity.class), REQUEST_1);
            firstTime = false;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, "Pulsa 'Atrás' para salir", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onPause ()
    {
        super.onPause();

        firstTime = true;
    }

    @Override
    public void onStop ()
    {
        super.onStop();

        firstTime = true;
    }
}
