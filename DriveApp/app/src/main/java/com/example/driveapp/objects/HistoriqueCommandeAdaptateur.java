package com.example.driveapp.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.driveapp.R;

import org.w3c.dom.Text;

import java.util.List;

public class HistoriqueCommandeAdaptateur extends BaseAdapter {

    private List<HistoriqueCommande> historiqueCommandeList;
    private Context context;

    public HistoriqueCommandeAdaptateur(List<HistoriqueCommande> historiqueCommandeList, Context context) {
        this.historiqueCommandeList = historiqueCommandeList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.historiqueCommandeList.size();
    }

    @Override
    public Object getItem(int positions) {
        return this.historiqueCommandeList.get(positions);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.historique_commande,null);
        }

        HistoriqueCommande current = (HistoriqueCommande) getItem(i);

        TextView date = view.findViewById(R.id.date);
        date.setText("Date : "+current.getDate());

        TextView cp = view.findViewById(R.id.cp);
        cp.setText("Code Postal :"+current.getCodepostal());

        TextView totale = view.findViewById(R.id.cp);
        totale.setText("Montant : "+Integer.toString(current.getMontant()));

        return view;
    }
}
