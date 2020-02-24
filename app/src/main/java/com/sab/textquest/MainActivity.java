package com.sab.textquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b_newGame;
    private Button b_quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_newGame = findViewById(R.id.b_start);
        b_quit = findViewById(R.id.b_quit);

        b_newGame.setOnClickListener(this);
        b_quit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.b_start):
                startActivity(new Intent(MainActivity.this, GameScreenActivity.class));
                break;
            case(R.id.b_quit):
                finish();
                break;
        }

    }
}
