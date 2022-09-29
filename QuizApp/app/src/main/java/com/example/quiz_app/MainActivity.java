package com.example.quiz_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    TextView toRegister,forgotPassword;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.LoginEmail);
        password=findViewById(R.id.LoginPassword);
        login=findViewById(R.id.LoginButton);
        toRegister=findViewById(R.id.ToRegister);
        forgotPassword=findViewById(R.id.ForgotPassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(email.getText().toString())||TextUtils.isEmpty(password.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"All the fields are required !!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    auth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {
                                        startActivity(new Intent(MainActivity.this,Quiz1.class));
                                    }else{
                                        Toast.makeText(getApplicationContext(),"Email or Password is incorrect !",Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                    );
                }
            }
        });
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Registre.class));
            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ResetPassword.class));
            }
        });
    }
}






