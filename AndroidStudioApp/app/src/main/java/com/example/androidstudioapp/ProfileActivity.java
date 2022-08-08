package com.example.androidstudioapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView TV1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.TV1 = findViewById(R.id.TV_nom_profil);

        String v = getIntent().getStringExtra("valeur");

        this.TV1.setText(v);
    }

    @Override
    public void onBackPressed(){

    }
}
