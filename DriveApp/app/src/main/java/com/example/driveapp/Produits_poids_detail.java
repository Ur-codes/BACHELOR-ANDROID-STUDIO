package com.example.driveapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Produits_poids_detail extends AppCompatActivity {

    private TextView dnom,dprix,dpoids;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        setTitle(getIntent().getStringExtra("nom"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_produit_poids);

        this.dnom = findViewById(R.id.d_pp_nom);
        this.dprix = findViewById(R.id.d_pp_prix);
        this.dpoids = findViewById(R.id.d_pp_poids);

        this.dnom.setText(getIntent().getStringExtra("nom"));
        this.dprix.setText(Integer.toString(getIntent().getIntExtra("prix",0)));
        this.dpoids.setText(Integer.toString(getIntent().getIntExtra("poids",0)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(Produits_poids_detail.this);
        inflater.inflate(R.menu.menu_detail,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
