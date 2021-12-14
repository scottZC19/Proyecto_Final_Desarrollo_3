package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class animacioninicio extends AppCompatActivity {
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_animacioninicio);
        mp=MediaPlayer.create(this, R.raw.sonidoinicio);

        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        TextView diabetictextview= findViewById(R.id.diabetictextview);
        TextView softtextview= findViewById(R.id.softtextview);
        ImageView logo = findViewById(R.id.logoicm);


        diabetictextview.setAnimation(animacion2);
        softtextview.setAnimation(animacion2);
        logo.setAnimation(animacion1);


        mp.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( animacioninicio.this,Splash.class);
                startActivity(intent);
                finish();
            }
        }, 5500);
    }
}