package com.example.quiz_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Registre extends AppCompatActivity {
    EditText name,email,password,confirmpassword;
    Button registre;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        mAuth = FirebaseAuth.getInstance();
        name=findViewById(R.id.Name);
        email=findViewById(R.id.RegisterEmail);
        password=findViewById(R.id.RegisterPassword);
        confirmpassword=findViewById(R.id.ConfirmPasswordRegister);
        registre=findViewById(R.id.RegisterButton);

        registre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(name.getText().toString())){
                    Toast.makeText(Registre.this, "Name is Required !!", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Email is Required !!",Toast.LENGTH_LONG).show();
                }
                if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Password is required !!",Toast.LENGTH_LONG).show();
                }
                if(TextUtils.isEmpty(confirmpassword.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Confirm password is required !!",Toast.LENGTH_LONG).show();
                }
                if(!confirmpassword.getText().toString().equals(password.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Passwords are not equal  !!!!!",Toast.LENGTH_LONG).show();
                }
                mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(Registre.this,new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(Registre.this,MainActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        });

    }
}

