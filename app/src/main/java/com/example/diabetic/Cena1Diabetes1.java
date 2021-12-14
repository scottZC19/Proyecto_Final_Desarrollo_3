package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cena1Diabetes1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cena1_diabetes1);
    }

    public void iryoutubedesayuno1(View view) {
        Button youtube;
        String _url = "https://dulcesdiabeticos.com/flan-casero-light-sin-azucar/";

        youtube = findViewById(R.id.btnyoutube);
        youtube.setOnClickListener(v -> {
            Uri _link = Uri.parse(_url);
            Intent i = new Intent(Intent.ACTION_VIEW,_link);
            startActivity(i);
        });

    }
}