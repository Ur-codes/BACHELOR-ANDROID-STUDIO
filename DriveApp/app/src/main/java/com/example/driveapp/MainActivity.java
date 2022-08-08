package com.example.driveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnp,btnc,btnhc,btna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnp = findViewById(R.id.bouton_produits);
        this.btnc = findViewById(R.id.bouton_commande);
        this.btnhc = findViewById(R.id.bouton_hcommande);
        this.btna = findViewById(R.id.bouton_propos);

        this.btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1 = new Intent(MainActivity.this,Produit_page.class);
                startActivity(in1);
            }
        });

        this.btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n2 = new Intent(MainActivity.this,A_Propos_page.class);
                startActivity(n2);
            }
        });

        this.btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        this.btnhc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent n3 = new Intent(MainActivity.this,List_HistoriqueCommande.class);
                startActivity(n3);

            }
        });

        setTitle("E-COMMERCE");


    }
}