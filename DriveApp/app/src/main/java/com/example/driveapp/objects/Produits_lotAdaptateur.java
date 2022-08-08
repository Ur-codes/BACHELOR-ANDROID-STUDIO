package com.example.driveapp.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.driveapp.R;

import java.util.List;

public class Produits_lotAdaptateur extends BaseAdapter {

   private List<Produits_lot> produits_lots;
   private Context context;

    public Produits_lotAdaptateur(List<Produits_lot> produits_lots, Context context) {
        this.produits_lots = produits_lots;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.produits_lots.size();
    }

    @Override
    public Object getItem(int position) {
        return produits_lots.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.produits_lot,null);
        }

        Produits_lot current = (Produits_lot)getItem(i);

        TextView nom = view.findViewById(R.id.nom_pl);
        nom.setText(current.getNom());

        TextView prix = view.findViewById(R.id.prix_pl);
        prix.setText("Prix :"+Integer.toString(current.getPrix()));

        TextView quantite = view.findViewById(R.id.quantite_pl);
        quantite.setText("Quantite :"+Integer.toString(current.getQuantite()));



        return view;
    }
}
