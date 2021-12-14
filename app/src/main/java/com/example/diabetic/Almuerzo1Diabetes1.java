package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Almuerzo1Diabetes1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almuerzo1_diabetes1);
    }

    public void iryoutubealmuerzo1diabetes1(View view) {

    }

    public void iryoutubedesayuno1(View view) {
        Button youtube;
        String _url = "https://www.youtube.com/watch?v=3I9X0NKpNug";

        youtube = findViewById(R.id.btnyoutube);
        youtube.setOnClickListener(v -> {
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            });

        }


}