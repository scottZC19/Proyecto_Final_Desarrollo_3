package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Diabetestipo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetestipo1);
    }

    public void irdietasdesayunotipo1(View view) {
        Intent intent = new Intent( Diabetestipo1.this,dietasdesayunotipo1.class);
        startActivity(intent);
    }

    public void irdietaspostretipo1(View view) {
        Intent intent = new Intent( Diabetestipo1.this,Dietaspostretipo1.class);
        startActivity(intent);
    }

    public void irdietascenatipo1(View view) {
        Intent intent = new Intent( Diabetestipo1.this,dietascenatipo1.class);
        startActivity(intent);
    }

    public void irdietasalmuerzotipo1(View view) {
        Intent intent = new Intent( Diabetestipo1.this,Dietasalmuerzotipo1.class);
        startActivity(intent);
    }
}