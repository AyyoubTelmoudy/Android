package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Quiz2 extends AppCompatActivity {
    Button suivant;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        suivant=findViewById(R.id.toQuiz3);

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Quiz2.this,Quiz3.class);
                intent.putExtra("quiz2",score+getIntent().getIntExtra("quiz1",0));
                startActivity(intent);
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.quiz2_rad1:
                if (checked)
                    score=1;
                break;
            case R.id.quiz2_rad2:
                if (checked)
                    score=0;
                break;
        }
    }
}