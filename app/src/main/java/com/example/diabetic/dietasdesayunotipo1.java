package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dietasdesayunotipo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietasdesayunotipo1);
    }

    public void irdesayuno1tipo1(View view) {
        Intent intent = new Intent( dietasdesayunotipo1.this,Desayuno1diabetes1.class);
        startActivity(intent);
    }
}