package com.example.guiderunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import kotlinx.coroutines.scheduling.Task;

public class regisztracio extends AppCompatActivity {

    public EditText regNEV;
    public EditText regEMail;
    public EditText regJelszo;
    public Button regBUTTON;
    public Button loginBUTTON;
    public String URL = "http://10.0.2.2:3000/accounts";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisztracio);
        init();
        regBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String nev = regNEV.getText().toString();
            String email = regEMail.getText().toString();
            String jelszo = regJelszo.getText().toString();

            Users users = new Users(nev,email,jelszo);
            Gson json = new Gson();
            RequestTask task = new RequestTask(URL,"POST",json.toJson(users));
            task.execute();

            Intent intent = new Intent(regisztracio.this, bejelentkezes.class);
            startActivity(intent);
            finish();
            }
        });
        loginBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(regisztracio.this, bejelentkezes.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init() {
        regNEV = findViewById(R.id.regNEV);
        regEMail = findViewById(R.id.regEMail);
        regJelszo = findViewById(R.id.regJelszo);
        regBUTTON = findViewById(R.id.regBUTTON);
        loginBUTTON = findViewById(R.id.loginBUTTON);
    }

    private class RequestTask extends AsyncTask<Void, Void, Response> {
        String requestUrl;
        String requestType;
        String requestParams;

        public RequestTask(String requestUrl, String requestType, String requestParams) {
            this.requestUrl = requestUrl;
            this.requestType = requestType;
            this.requestParams = requestParams;
        }


        public RequestTask(String requestUrl, String requestType) {
            this.requestUrl = requestUrl;
            this.requestType = requestType;
        }

        @Override
        protected Response doInBackground(Void... voids) {
            Response response = null;
            try {
                switch (requestType) {
                    case "GET":
                        response = RequestHandler.get(requestUrl);
                        break;
                    case "POST":
                        response = RequestHandler.post(requestUrl, requestParams);
                        break;
                    case "PUT":
                        response = RequestHandler.put(requestUrl, requestParams);
                        break;
                    case "DELETE":
                        response = RequestHandler.delete(requestUrl + "/" + requestParams);
                        break;
                }
            } catch (IOException e) {
                Toast.makeText(regisztracio.this,
                        e.toString(), Toast.LENGTH_SHORT).show();
            }
            return response;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Response response) {
            super.onPostExecute(response);

            if (response.getResponseCode() >= 400) {
                Toast.makeText(regisztracio.this,
                        "Hiba történt a kérés feldolgozása során", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(regisztracio.this, "Sikeres regisztráció", Toast.LENGTH_SHORT).show();
            }
            switch (requestType) {
                case "GET":
                    break;
                case "POST":
                    break;
                case "PUT":
                    break;
                case "DELETE":
                    break;
            }
        }
    }

}