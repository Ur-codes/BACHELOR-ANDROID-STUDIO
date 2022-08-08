package com.example.testapp2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class OrdinateurAdapter extends BaseAdapter {


    private List<Ordinateur> lordi;
    private Context context;

    public OrdinateurAdapter(List<Ordinateur> lordi, Context context) {
        this.lordi = lordi;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.lordi.size();
    }

    @Override
    public Object getItem(int position) {
        return lordi.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.ordinateur,null);
        }
        Ordinateur current = (Ordinateur) getItem(i);
        TextView marque = view.findViewById(R.id.ordinateur_marque);
        marque.setText(current.getMarque());

        TextView model = view.findViewById(R.id.ordinateur_modele);
        model.setText(current.getModele());

        if(i%2==0){
            view.setBackgroundColor(Color.GRAY);
        }
        else {
            view.setBackgroundColor(Color.RED);
        }
        return view;
    }
}
