package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Diabetestipo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetestipo2);
    }

    public void irdietaspostre2(View view) {
        Intent intent = new Intent( Diabetestipo2.this,dietaspostretipo2.class);
        startActivity(intent);
    }

    public void irdietascena2(View view) {
        Intent intent = new Intent( Diabetestipo2.this,dietacenatipo2.class);
        startActivity(intent);
    }

    public void irdietasalmuerzo2(View view) {
        Intent intent = new Intent( Diabetestipo2.this,dietaalmuerzotipo2.class);
        startActivity(intent);
    }

    public void irdietasdesayuno2(View view) {
        Intent intent = new Intent( Diabetestipo2.this,dietadesayunotipo2.class);
        startActivity(intent);
    }
}