package com.example.diabetic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.login.LoginManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

public class Tipodediabetes extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private LoginManager mFac;



    Button diabetes1,diabetes2, musica, imc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipodediabetes);
        initViews();

    }

    private void initViews(){
        mAuth = FirebaseAuth.getInstance();
    }

    public void irespecialista(View view) {
        Button especialista;
        String _url = "http://www.essalud.gob.pe/centro-especializado-en-atencion-integral-en-diabetes-e-hipertension-cedhi/";

        especialista = findViewById(R.id.btnespecialista);
        especialista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });
    }


    public void iroficina(View view) {

        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("¡¡¡Espere!!!");
        builder.setMessage("Primero active su ubicacion para que funcione de forma adecuada el aplicativo");
        builder.setPositiveButton("Ya lo active", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent( Tipodediabetes.this,Rutas.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Regresar", null);
        Dialog dialog = builder.create();
        dialog.show();



    }
    public void clickcerrarsesion(View view) {
        mAuth.signOut();
        Intent i= new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();

        LoginManager.getInstance().logOut();
    }


    public void irdiabetestipo1(View view) {
        Intent intent = new Intent( Tipodediabetes.this,Diabetestipo1.class);
        startActivity(intent);
    }

    public void irdiabetestipo2(View view) {
        Intent intent = new Intent( Tipodediabetes.this,Diabetestipo2.class);
        startActivity(intent);
    }

    public void irtelegram(View view) {
        Button telegram;
        String _url = "https://t.me/comidalife";

        telegram = findViewById(R.id.btntelegram);
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });
    }

    public void irfacebook(View view) {
    }

    public void irinstagram(View view) {

    }

    public void irwhatsap(View view) {
    }
}