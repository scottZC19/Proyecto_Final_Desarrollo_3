package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dietaspostretipo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietaspostretipo1);
    }

    public void irpostre1diabetes1(View view) {
        Intent intent = new Intent( Dietaspostretipo1.this, Postre11diabetes1.class);
        startActivity(intent);
    }
}