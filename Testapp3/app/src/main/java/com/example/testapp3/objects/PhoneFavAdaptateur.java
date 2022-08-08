package com.example.testapp3.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testapp3.R;

import java.util.List;

public class PhoneFavAdaptateur extends BaseAdapter {

    private List<PhoneFav> phonefavs;
    private Context context;

    public PhoneFavAdaptateur(List<PhoneFav> phonefavs, Context context) {
        this.phonefavs = phonefavs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.phonefavs.size();
    }

    @Override
    public Object getItem(int position) {
        return phonefavs.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.activity_phone_favoris,null);
        }
        PhoneFav current = (PhoneFav)getItem(i);
        TextView name = view.findViewById(R.id.phone_name3);
        name.setText(current.getName());

        return view;
    }
}
