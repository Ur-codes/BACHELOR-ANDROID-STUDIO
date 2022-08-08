package com.example.driveapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Produit_page extends AppCompatActivity {

    private Button btnpp,btnpl;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.produits);
        setTitle("Type de produits");


        this.btnpp = findViewById(R.id.bouton_pp);
        this.btnpl = findViewById(R.id.bouton_pl);




        this.btnpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n1 = new Intent(Produit_page.this,List_Produits_poids.class);
                startActivity(n1);
            }
        });
        this.btnpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n2 = new Intent(Produit_page.this,List_Produits_lot.class);
                startActivity(n2);
            }
        });
    }
}
