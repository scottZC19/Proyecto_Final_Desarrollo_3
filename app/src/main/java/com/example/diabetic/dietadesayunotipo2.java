package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dietadesayunotipo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietadesayunotipo2);
    }



    public void irdesayuno1tipo2(View view) {
        Intent intent = new Intent( dietadesayunotipo2.this,Desayuno1diabetes2.class);
        startActivity(intent);
    }
}