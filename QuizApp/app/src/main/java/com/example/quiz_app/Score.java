package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quiz_app.databinding.ActivityScoreBinding;

public class Score extends AppCompatActivity {

    private ActivityScoreBinding binding;
    Integer totaleScore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_score);
        Intent intent=new Intent(Score.this,Quiz1.class);

        totaleScore=25*getIntent().getIntExtra("quiz4",0);
        binding.donutProgress.setDonut_progress(totaleScore.toString());

        binding.toTrayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(intent);
            }
        });
        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Score.this,MainActivity.class));
            }
        });
    }

}