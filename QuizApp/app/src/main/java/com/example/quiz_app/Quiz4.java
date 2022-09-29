package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Quiz4 extends AppCompatActivity {
    Button suivant;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        suivant=findViewById(R.id.toScore);

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Quiz4.this,Score.class);
                intent.putExtra("quiz4",score+getIntent().getIntExtra("quiz3",0));
                startActivity(intent);
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.quiz4_rad1:
                if (checked)
                   score=0;
                break;
            case R.id.quiz4_rad2:
                if (checked)
                    score=1;
                break;
        }
    }

}