package com.example.diabetic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class registro extends AppCompatActivity implements View.OnClickListener {

    EditText contrasenia, correoelectronico, nombres1, apeelidos1, telefono1;
    Button registrabtn;
    private ProgressDialog mProgressBar;

    //datos que se registran



    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    private String nombresbd = ";";
    private String apellidobd = ";";
    private String telefonobd = ";";
    private String correobd = ";";
    private String contraseniabd = ";";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombres1 = findViewById(R.id.txtNombres);
        apeelidos1 = findViewById(R.id.txtApellidos);
        telefono1 = findViewById(R.id.txtTelefono);
        contrasenia = findViewById(R.id.txtcontrasenia);
        correoelectronico = findViewById(R.id.txtcorreo);



        registrabtn = findViewById(R.id.btnregistrarse);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        if(mAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),Tipodediabetes.class));
            finish();
        }

        registrabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // el método trim sirve manipulación de cadenas (String), el cual sirve para quitar los espacios a la cadena

                nombresbd = nombres1.getText().toString();
                apellidobd = apeelidos1.getText().toString();
                telefonobd = telefono1.getText().toString();

                correobd = correoelectronico.getText().toString();
                contraseniabd = contrasenia.getText().toString();
                //validar los datos que se ingresaron
                if(TextUtils.isEmpty(nombresbd)){
                    Toast.makeText(getApplicationContext(),"ingrese sus nombres", Toast.LENGTH_SHORT).show();
                    nombres1.setError("nombres es requerido");
                    return;
                }
                if(TextUtils.isEmpty(apellidobd)){
                    Toast.makeText(getApplicationContext(),"ingrese sus apellidos", Toast.LENGTH_SHORT).show();
                    apeelidos1.setError("apellidos es requerido");
                    return;
                }
                if(TextUtils.isEmpty(telefonobd)){
                    Toast.makeText(getApplicationContext(),"ingrese su telefono", Toast.LENGTH_SHORT).show();
                    telefono1.setError("telefono es requerido");
                    return;
                }
                if(TextUtils.isEmpty(correobd)){
                    Toast.makeText(getApplicationContext(),"ingrese su correo electronico", Toast.LENGTH_SHORT).show();
                    correoelectronico.setError("Email es requerido");
                    return;
                }
                if(TextUtils.isEmpty(contraseniabd)){
                    contrasenia.setError("Password es requerido");
                    Toast.makeText(getApplicationContext(),"ingrese una contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }
                //si es nenor a 6 caracteres
                if(contrasenia.length()<6){

                    Toast.makeText(getApplicationContext(),"su contraseña tiene que ser  mayor a 6 caracteres", Toast.LENGTH_SHORT).show();
                    contrasenia.setError("su contraseña tiene que ser  mayor a 6 caracteres");
                    return;
                }


                //REGISTRO DE USER EN FIREBASE
                // enviar datos firebase como (email - password) - oyente que nos confirme si el registro se realizo exitoso o no  <resultado autenticacion>
                mAuth.createUserWithEmailAndPassword(correobd,contraseniabd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // si la tarea es exitosa
                        if(task.isSuccessful()){

                            Map<String,Object> map = new HashMap<>();
                            map.put("nombres",nombresbd);
                            map.put("apellidos", apellidobd);
                            map.put("telefono", telefonobd);
                            map.put("correo",correobd);
                            map.put("contrasenia",contraseniabd);






                            String id = mAuth.getCurrentUser().getUid();
                            mDatabase.child("usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task2) {

                                    Toast.makeText(registro.this,"Usuario creado exitosamente",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),Tipodediabetes.class));
                                }
                            });


                        }else{
                            Toast.makeText(registro.this,
                                    " Se produjo un ERROR! usuario no creado" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            //

                        }
                    }
                });

            }
        });

    }



    @Override
    public void onClick(View v) {

    }

    public void ingresarmain(View view) {
    Intent intent = new Intent( registro.this,MainActivity.class);
    startActivity(intent);
    }

    private void registrarusuario(){
        
    }
}