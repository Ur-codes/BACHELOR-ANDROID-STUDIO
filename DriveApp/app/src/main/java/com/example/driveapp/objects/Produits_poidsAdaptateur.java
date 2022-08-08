package com.example.driveapp.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.driveapp.R;

import java.util.List;

public class Produits_poidsAdaptateur extends BaseAdapter {

    private List<Produits_poids> produits_poids;
    private Context context;

    public Produits_poidsAdaptateur(List<Produits_poids> produits_poids, Context context) {
        this.produits_poids = produits_poids;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.produits_poids.size();
    }

    @Override
    public Object getItem(int position) {
        return produits_poids.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.produits_poids,null);
        }

        Produits_poids current = (Produits_poids) getItem(i);

        TextView nom = view.findViewById(R.id.nom_pp);
        nom.setText(current.getNom());

        TextView prix = view.findViewById(R.id.prix_pp);
        prix.setText("Prix :"+Integer.toString(current.getPrix()));

        TextView poids = view.findViewById(R.id.poids_pp);
        poids.setText("Poids :"+Integer.toString(current.getPoids()));


        return view;
    }
}
