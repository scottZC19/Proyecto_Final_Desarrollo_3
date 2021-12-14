package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dietasalmuerzotipo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietasalmuerzotipo1);
    }

    public void iralmuerzo1diabetes1(View view) {
        Intent intent = new Intent( Dietasalmuerzotipo1.this,Almuerzo1Diabetes1.class);
        startActivity(intent);
    }
}