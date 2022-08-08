package com.example.driveapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.driveapp.objects.Produits_poids;
import com.example.driveapp.objects.Produits_poidsAdaptateur;

import java.util.ArrayList;
import java.util.List;

public class List_Produits_poids extends AppCompatActivity {

    private ListView lvpp;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Liste produits en poids");
        setContentView(R.layout.list_produits_poids);

        this.lvpp = findViewById(R.id.ListViewPP);
        Produits_poidsAdaptateur produits_poidsAdaptateur = new Produits_poidsAdaptateur(getProduits_poids(),List_Produits_poids.this);
        this.lvpp.setAdapter(produits_poidsAdaptateur);

        this.lvpp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(List_Produits_poids.this,Produits_poids_detail.class);
                in.putExtra("nom",getProduits_poids().get(i).getNom());
                in.putExtra("prix",getProduits_poids().get(i).getPrix());
                in.putExtra("poids",getProduits_poids().get(i).getPoids());

                startActivity(in);
            }
        });






    }

    public List<Produits_poids> getProduits_poids(){
        List<Produits_poids> res = new ArrayList<>();

        res.add(new Produits_poids("Patates",6,5));
        res.add(new Produits_poids("Poires",3,9));
        res.add(new Produits_poids("Pommes",11,2));


        return res;
    }
}
