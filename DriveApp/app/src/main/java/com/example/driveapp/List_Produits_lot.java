package com.example.driveapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.driveapp.objects.Produits_lot;
import com.example.driveapp.objects.Produits_lotAdaptateur;

import java.util.ArrayList;
import java.util.List;

public class List_Produits_lot extends AppCompatActivity {

    private ListView lvpl;

    @Override
    protected void onPostCreate( Bundle savedInstanceState) {
        setTitle("Liste des produits en lot");
        super.onPostCreate(savedInstanceState);

        setContentView(R.layout.list_produits_lot);
        this.lvpl = findViewById(R.id.ListViewPL);

        Produits_lotAdaptateur produits_lotAdaptateur = new Produits_lotAdaptateur(getProduit_lot(),List_Produits_lot.this);
        this.lvpl.setAdapter(produits_lotAdaptateur);

        this.lvpl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(List_Produits_lot.this,Produits_lot_detail.class);
                in.putExtra("nom",getProduit_lot().get(i).getNom());
                in.putExtra("prix",getProduit_lot().get(i).getPrix());
                in.putExtra("quantite",1);

                startActivity(in);
            }
        });
    }


    public List<Produits_lot> getProduit_lot(){
        List<Produits_lot> res = new ArrayList<>();

        res.add(new Produits_lot("Concerves",5));
        res.add(new Produits_lot("Sodas",10));
        res.add(new Produits_lot("Bouteilles",3));

        return res;
    }
}
