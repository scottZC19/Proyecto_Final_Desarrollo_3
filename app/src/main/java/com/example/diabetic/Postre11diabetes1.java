package com.example.diabetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Postre11diabetes1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postre11diabetes1);
    }

    public void irpostre1diabetes1(View view) {
        Button youtube;
        String _url = "https://www.youtube.com/watch?v=xovuUbrZCb0&ab_channel=EntreFogonesest%C3%A1nlosGenes";

        youtube = findViewById(R.id.btnyoutube);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });
    }
}