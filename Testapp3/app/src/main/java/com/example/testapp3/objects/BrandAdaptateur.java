package com.example.testapp3.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testapp3.R;

import java.util.List;

public class BrandAdaptateur extends BaseAdapter {

    private List<Brand> brands;
    private Context context;

    public BrandAdaptateur(List<Brand> brands, Context context) {
        this.brands = brands;
        this.context = context;
    }
    @Override
    public int getCount() {
        return this.brands.size();
    }

    @Override
    public Object getItem(int position) {
        return brands.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup){
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.brand,null);
        }
        Brand current = (Brand)getItem(i);
        TextView marque = view.findViewById(R.id.brandname);
        marque.setText(current.getName());

        TextView slug = view.findViewById(R.id.brandslug);
        slug.setText(current.getBrand_slug());

        TextView nb = view.findViewById(R.id.brandcount);
        nb.setText(String.valueOf(current.getDevice_count()));

        return view;
    }
}
