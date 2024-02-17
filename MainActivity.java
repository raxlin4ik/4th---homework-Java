package com.raxlin4ik.myapplication;

import static android.widget.Toast.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView score;
    private Button lionsTeam, panthersTeam;
    private int countLions = 0, countPanthers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeText(this, "Создание активности", LENGTH_SHORT).show();
        // Добавить наш XML
        setContentView(R.layout.activity_main);

        score = findViewById(R.id.score);
        lionsTeam = findViewById(R.id.lionsTeam);
        panthersTeam = findViewById(R.id.panthersTeam);
        lionsTeam.setOnClickListener(listener);
        panthersTeam.setOnClickListener(listener);
    }
    @Override
    protected void onStart() {
        super.onStart();
        makeText(this, "Запуск активности", LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeText(this, "Открытие взаимодействия с активностью", LENGTH_SHORT).show();
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lions", countLions);
        outState.putInt("panthers", countPanthers);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        countLions = savedInstanceState.getInt("lions");
        countPanthers = savedInstanceState.getInt("panthers");
        score.setText(String.format("%02d", countLions) + " : " + String.format("%02d", countPanthers));
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.lionsTeam:
                    countLions++;
                    break;
                case R.id.panthersTeam:
                    countPanthers++;
                    break;
            }
            score.setText(String.format("%02d", countLions) + " : " + String.format("%02d", countPanthers));
        }
    };
}
