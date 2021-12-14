package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dietascenatipo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietascenatipo1);
    }

    public void ircena1diabetes1(View view) {
        Intent intent = new Intent( dietascenatipo1.this,Cena1Diabetes1.class);
        startActivity(intent);
    }
}