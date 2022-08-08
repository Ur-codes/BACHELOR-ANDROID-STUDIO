package com.example.driveapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Produits_lot_detail extends AppCompatActivity {

    private TextView dnom,dprix,dquantite;

    @Override
    protected void onCreate( Bundle savedInstanceState) {

        setTitle(getIntent().getStringExtra("nom"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_produit_lot);

        this.dnom = findViewById(R.id.d_pl_nom);
        this.dprix = findViewById(R.id.d_pl_prix);
        this.dquantite = findViewById(R.id.d_pl_quantite);

        this.dnom.setText(getIntent().getStringExtra("nom"));
        this.dprix.setText(Integer.toString(getIntent().getIntExtra("prix",0)));
        this.dquantite.setText(Integer.toString(getIntent().getIntExtra("quantite",0)));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(Produits_lot_detail.this);
        inflater.inflate(R.menu.menu_detail,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
