package com.example.androidstudioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b_click1;
    private EditText e_text1;
    private String e_text2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.b_click1 = findViewById(R.id.B1);
        this.e_text1 = findViewById(R.id.ET1);
        SharedPreferences settings = getSharedPreferences( "mydictionnary" , Context.MODE_PRIVATE);
        this.e_text2 = settings.getString("pseudo",null);

        if (!e_text2.isEmpty()) {
            setTitle("Bienvenue " + e_text2);
        }

        this.b_click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this , "coucou" , Toast.LENGTH_SHORT).show();
            }
        });
        this.b_click1 = findViewById(R.id.B2);
        this.b_click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.popup_titre)
                        .setMessage(R.string.popup_contenu)
                        .setPositiveButton(R.string.popup_oui, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.popup_non, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setCancelable(false)
                        .show();
            }
        });
        this.b_click1 = findViewById(R.id.B3);
        this.b_click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String contenu = e_text1.getText().toString();

                Intent i = new Intent(MainActivity.this, ProfileActivity.class);

                if(!contenu.isEmpty()) {



                    i.putExtra("valeur", contenu);
                    startActivity(i);
                }
                else{
                   e_text1.setError("Saisie obligatoire");
                }
            }
        });

        this.b_click1 = findViewById(R.id.B4);
        this.b_click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent j = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(j);
            }
        });

    }
}