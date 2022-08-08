package com.example.testapp3.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapp3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SlugAdaptateur extends BaseAdapter {

    private List<Slug> slugs;
    private Context context;

    public SlugAdaptateur(List<Slug> slugs, Context context) {
        this.slugs = slugs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.slugs.size();
    }

    @Override
    public Object getItem(int position) {
        return slugs.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.brand_slug,null);
        }
        Slug current = (Slug) getItem(i);

        ImageView img = view.findViewById(R.id.IV);
        Picasso.get().load(current.getBrand()).into(img);

        TextView phonename = view.findViewById(R.id.phone_name);
        phonename.setText(current.getPhone_name());

        TextView slug = view.findViewById(R.id.slug);
        slug.setText(current.getSlug());

        return view;
    }
}
