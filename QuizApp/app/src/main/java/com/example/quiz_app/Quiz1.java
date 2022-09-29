package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz1 extends AppCompatActivity {

    Button suivant;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        suivant=findViewById(R.id.toQuiz2);


        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Quiz1.this,Quiz2.class);
                intent.putExtra("quiz1",score);
                startActivity(intent);
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.quiz1_rad1:
                if (checked)
                    score=1;
                    break;
            case R.id.quiz1_rad2:
                if (checked)
                    score=0;
                    break;
        }
    }
}