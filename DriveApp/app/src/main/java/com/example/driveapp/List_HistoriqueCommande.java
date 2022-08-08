package com.example.driveapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.driveapp.objects.HistoriqueCommande;
import com.example.driveapp.objects.HistoriqueCommandeAdaptateur;

import java.util.ArrayList;
import java.util.List;

public class List_HistoriqueCommande extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_historique_commande);

        this.lv = findViewById(R.id.ListViewHC);

        HistoriqueCommandeAdaptateur historiqueCommandeAdaptateur = new HistoriqueCommandeAdaptateur(gethistoriqueCommande(),List_HistoriqueCommande.this);
        this.lv.setAdapter(historiqueCommandeAdaptateur);


    }

    public List<HistoriqueCommande> gethistoriqueCommande(){

        List<HistoriqueCommande> res = new ArrayList<>();

        res.add(new HistoriqueCommande("18 Janvier","95870",1322));
        res.add(new HistoriqueCommande("1 Juin","75100",122));

        return res;
    }
}
