package com.example.guiderunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class bejelentkezes extends AppCompatActivity {

    public EditText logNEV;
    public EditText logJelszo;
    public Button loginBUTTON;
    public Button regBUTTON;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bejelentkezes);
        init();
        regBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bejelentkezes.this,regisztracio.class);
                startActivity(intent);
                finish();
            }
        });
        loginBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bejelentkezes.this,penisoooo.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init(){
        logNEV = findViewById(R.id.logNEV);
        logJelszo = findViewById(R.id.logJelszo);
        regBUTTON = findViewById(R.id.regBUTTON);
        loginBUTTON = findViewById(R.id.loginBUTTON);
    }
}