package com.example.diabetic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    Button ingresar, registrarse ;
    EditText correo, contrasenia;



    private FirebaseAuth mAuth;

    private static final String TAG = "FacebookLogin";


    private CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();
        correo = findViewById(R.id.txtcorreomain);
        contrasenia = findViewById(R.id.txtcontraseniamain);







        registrarse = findViewById(R.id.btnregistro);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamarregistrase();
            }
        });


        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        // [START initialize_fblogin]
        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
            }
        });
        // [END initialize_fblogin]
    }

    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    // [END on_start_check_user]

    // [START on_activity_result]
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
    // [END on_activity_result]

    // [START auth_with_facebook]
    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            Intent intent = new Intent(MainActivity.this, Tipodediabetes.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(MainActivity.this,"Ingreso correctamente",Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            updateUI(null);
                            Intent intent = new Intent(MainActivity.this, Tipodediabetes.class);
                            startActivity(intent);
                            finish();

                        }
                    }
                });
    }
    // [END auth_with_facebook]

    private void updateUI(FirebaseUser user) {

        FirebaseUser user1=FirebaseAuth.getInstance().getCurrentUser();
        if (user1 !=null){
            Intent intent = new Intent(MainActivity.this, Tipodediabetes.class);
            startActivity(intent);
            finish();
            Toast.makeText(MainActivity.this,"Bienvenido",Toast.LENGTH_SHORT).show();

        }



    }







    public void iniciarsesion(View view){

        String correo2 =correo.getText().toString().trim();
        String contrasenia2 =contrasenia.getText().toString().trim();

        if (TextUtils.isEmpty(correo2)){

            correo.setError("Email es requerido");
            Toast.makeText(getApplicationContext(),"Debe de escribir su correo", Toast.LENGTH_SHORT).show();

            return;
        }
        if (TextUtils.isEmpty(contrasenia2)){
            contrasenia.setError("Contraseña es requerida");
            Toast.makeText(getApplicationContext(),"Debe de escribir su contraseña", Toast.LENGTH_SHORT).show();
            return;
        }



        mAuth.signInWithEmailAndPassword(correo.getText().toString(),contrasenia.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {




            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {



                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Bienvenido", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    Intent i = new Intent(getApplicationContext(),Tipodediabetes.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"Correo o Contraseña incorrectos", Toast.LENGTH_SHORT).show();

                }
            }
        });







    }

    private void llamarregistrase() {
        Intent intent = new Intent( MainActivity.this,registro.class);
        startActivity(intent);
    }



    public void irfacebook(View view) {

        Button facebook;
        String _url = "https://web.facebook.com/groups/1480787015572827";

        facebook = findViewById(R.id.btnfacebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });
    }

    public void irinstagram(View view) {
        Button instagram;
        String _url = "https://www.instagram.com/lavienutritive/?hl=es";

        instagram = findViewById(R.id.btninstagram);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });
    }

    public void irwhatsap(View view) {
        Button whatsap;
        String _url = "https://chat.whatsapp.com/EhjG5l7NJfI7YMpXG3HHHV";

        whatsap = findViewById(R.id.btnwhatsap);
        whatsap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });
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
}