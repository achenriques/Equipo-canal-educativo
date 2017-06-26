package com.example.alex.equipo_canal_educativo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Alex on 08/11/2016.
 */

public class Activity4 extends AppCompatActivity {

    private TextView cuenta1;
    private TextView cuenta2;
    private TextView cuenta3;
    private TextView cuenta4;
    private TextView resultado;

    private CheckBox c1;
    private CheckBox c2;
    private CheckBox c3;
    private CheckBox c4;

    private EditText result1;
    private EditText result2;
    private EditText result3;
    private EditText result4;

    private int suma1;
    private int suma2;
    private int resta1;
    private int resta2;
    private int mult1;
    private int mult2;
    private int div;
    private int puntuacion = 0;
    private int res = 0;

    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        puntuacion = preferences.getInt("puntuacionMates", 0);

        cuenta1 = (TextView) this.findViewById( R.id.a4_cuenta1 );
        cuenta2 = (TextView) this.findViewById( R.id.a4_cuenta2 );
        cuenta3 = (TextView) this.findViewById( R.id.a4_cuenta3 );
        cuenta4 = (TextView) this.findViewById( R.id.a4_cuenta4 );
        resultado = (TextView) this.findViewById( R.id.a4_resultado );

        result1 = (EditText) this.findViewById( R.id.a4_result1 );
        result2 = (EditText) this.findViewById( R.id.a4_result2 );
        result3 = (EditText) this.findViewById( R.id.a4_result3 );
        result4 = (EditText) this.findViewById( R.id.a4_result4 );

        c1 = (CheckBox) findViewById(R.id.a4_check1);
        c2 = (CheckBox) findViewById(R.id.a4_check2);
        c3 = (CheckBox) findViewById(R.id.a4_check3);
        c4 = (CheckBox) findViewById(R.id.a4_check4);

        final Button br = (Button) findViewById(R.id.a4_btReset);

        suma1= randomGenerator();
        suma2= randomGenerator();
        cuenta1.setText(Integer.toString(suma1)+ " + " + Integer.toString(suma2) + " =");   //Inicializa las cuentas

        do {
            resta1 = randomGenerator();
            resta2 = randomGenerator();
        }while(resta1 <= resta2);
        cuenta2.setText(Integer.toString(resta1)+ " - " + Integer.toString(resta2) + " =");

        mult1= randomGenerator();
        mult2= randomGenerator();
        cuenta3.setText(Integer.toString(mult1)+ " * " + Integer.toString(mult2) + " =");

        do{
            div = randomGenerator();
        }while(div<1);
        cuenta4.setText(Integer.toString(div) + " / " + Integer.toString(esDivisible(div)) + " ="); //Se inicia con una division de enteros simple

        resultado.setText("Puntuación: " + Integer.toString(puntuacion));

        result1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(result1.getText().toString().trim().length()>0)
                {
                    if(Integer.parseInt(result1.getText().toString().trim()) == (suma1 + suma2))
                    {
                        c1.setChecked(true);
                        result1.setFocusable(false);
                        result1.setFocusableInTouchMode(false);
                        puntuacion+=10;
                        resultado.setText("Puntuación: " + Integer.toString(puntuacion));
                        res++;
                        if(res == 4) {
                            cerrarTeclado(result1);
                            Toast.makeText(Activity4.this, "Pulsa RESETEAR CUENTAS para seguir jugando", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        result2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(result2.getText().toString().trim().length()>0)
                {
                    if(Integer.parseInt(result2.getText().toString().trim()) == (resta1 - resta2))
                    {
                        c2.setChecked(true);
                        result2.setFocusable(false);
                        result2.setFocusableInTouchMode(false);
                        puntuacion+=10;
                        resultado.setText("Puntuación: " + Integer.toString(puntuacion));
                        res++;
                        if(res == 4){
                            cerrarTeclado(result2);
                            Toast.makeText(Activity4.this, "Pulsa RESETEAR CUENTAS para seguir jugando", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        result3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(result3.getText().toString().trim().length()>0)
                {
                    if(Integer.parseInt(result3.getText().toString().trim()) == (mult1 * mult2))
                    {
                        c3.setChecked(true);
                        result3.setFocusable(false);
                        result3.setFocusableInTouchMode(false);
                        puntuacion+=10;
                        resultado.setText("Puntuación: " + Integer.toString(puntuacion));
                        res++;
                        if(res == 4) {
                            cerrarTeclado(result3);
                            Toast.makeText(Activity4.this, "Pulsa RESETEAR CUENTAS para seguir jugando", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        result4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (result4.getText().toString().trim().length() > 0)
                {
                    if (Integer.parseInt(result4.getText().toString()) == (div / esDivisible(div)))
                    {
                        c4.setChecked(true);
                        result4.setFocusable(false);
                        result4.setFocusableInTouchMode(false);
                        puntuacion += 10;
                        resultado.setText("Puntuación: " + Integer.toString(puntuacion));
                        res++;
                        if(res == 4) {
                            cerrarTeclado(result4);
                            Toast.makeText(Activity4.this, "Pulsa RESETEAR CUENTAS para seguir jugando", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putInt( "puntuacionMates", puntuacion );
                editor.apply();
                //startActivity( new Intent(Activity4.this, Activity4.class));
                resetear();
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
        MenuItem it = menu.findItem(R.id.menu_mates);
        it.setVisible(false);

        it = menu.findItem(R.id.menu_silencio);
        it.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        editor.putInt( "puntuacionMates", puntuacion );
        editor.apply();

        boolean toret = false;
        switch( menuItem.getItemId() ) {
            case R.id.menu_figuras:
                startActivity( new Intent(Activity4.this, Activity2.class));
                toret = true;
                break;
            case R.id.menu_dibujos:
                startActivity( new Intent(Activity4.this, Activity3.class));
                toret = true;
                break;
            //case R.id.menu_mates:
                /*startActivityForResult( new Intent(Activity4.this, Activity4.class), REQUEST_CODE);
                toret = true;
                break;*/
            case R.id.menu_volver:
                MainActivity.firstTime = false; //Para q no muestre pantalla de bienvenida
                startActivity( new Intent(Activity4.this, MainActivity.class));
                toret = true;
                break;
            case R.id.menu_punt:
                editor.remove("puntuacionMates");
                if(editor.commit())
                    puntuacion = 0;
                    resultado.setText("Puntuación: 0");
                toret = true;
                break;
        }
        return toret;
    }

    public void resetear()
    {
        res = 0; //Para resetear el toast, al llegar a 4 se muestra

        suma1= randomGenerator();
        suma2= randomGenerator();
        cuenta1.setText(Integer.toString(suma1)+ " + " + Integer.toString(suma2) + " =");   //Inicializa las cuentas

        do {
            resta1 = randomGenerator();
            resta2 = randomGenerator();
        }while(resta1 <= resta2);
        cuenta2.setText(Integer.toString(resta1)+ " - " + Integer.toString(resta2) + " =");

        mult1= randomGenerator();
        mult2= randomGenerator();
        cuenta3.setText(Integer.toString(mult1)+ " * " + Integer.toString(mult2) + " =");

        do{
            div = randomGenerator();
        }while(div<1);
        cuenta4.setText(Integer.toString(div) + " / " + Integer.toString(esDivisible(div)) + " ="); //Se inicia con una division de enteros simple

        resultado.setText("Puntuación: " + Integer.toString(puntuacion));

        c1.setChecked(false);
        result1.setText("");
        result1.setFocusable(true);
        result1.setFocusableInTouchMode(true);

        c2.setChecked(false);
        result2.setText("");
        result2.setFocusable(true);
        result2.setFocusableInTouchMode(true);

        c3.setChecked(false);
        result3.setText("");
        result3.setFocusable(true);
        result3.setFocusableInTouchMode(true);

        c4.setChecked(false);
        result4.setText("");
        result4.setFocusable(true);
        result4.setFocusableInTouchMode(true);
    }

    public int randomGenerator()
    {
        Random toret = new Random();
        return toret.nextInt(10);
    }

    public int esDivisible(int x)
    {
        int i = x;

        if(x == 1)
            return i;

        while(x%--i != 0)
        {}

        return i;
    }

    public void cerrarTeclado (EditText t)
    {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(t.getWindowToken(), 0);

    }

}
