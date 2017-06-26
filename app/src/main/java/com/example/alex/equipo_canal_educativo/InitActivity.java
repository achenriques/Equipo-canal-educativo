package com.example.alex.equipo_canal_educativo;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class InitActivity extends AppCompatActivity {

    private Thread openActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        ActionBar actionBar = getSupportActionBar();    //Esconder la barra de título
        actionBar.hide();

        /*openActivity = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);

                }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(InitActivity.this, "Error en sleep", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    @Override
    protected void onResume ()
    {
        super.onResume();

        new CountDownTimer(5000, 3000) {

            public void onTick(long millisUntilFinished) {
                //Toast.makeText(InitActivity.this, "Empecemos", Toast.LENGTH_SHORT).show();
            }

            public void onFinish() {
                Toast.makeText(InitActivity.this, "Empecemos", Toast.LENGTH_SHORT).show();
                finalizada();
            }
        }.start();
    }

    private void finalizada ()
    {
        MainActivity.firstTime = false;
        InitActivity.this.setResult( RESULT_OK );
        InitActivity.this.finish();
    }
}
