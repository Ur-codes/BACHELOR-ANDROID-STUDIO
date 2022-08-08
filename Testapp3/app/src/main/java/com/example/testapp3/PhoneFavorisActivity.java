package com.example.testapp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp3.objects.PhoneFav;
import com.example.testapp3.objects.PhoneFavAdaptateur;

import java.util.List;

public class PhoneFavorisActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DBPhone db = new DBPhone(PhoneFavorisActivity.this);
        db.open();
        List<PhoneFav> phones = db.getFavoris();
        db.close();

        setContentView(R.layout.activity_phone_favoris);

        this.listView = findViewById(R.id.ListFav);

        PhoneFavAdaptateur phoneFavAdaptateur = new PhoneFavAdaptateur(phones,PhoneFavorisActivity.this);
        this.listView.setAdapter(phoneFavAdaptateur);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = ((PhoneFav) adapterView.getAdapter().getItem(i)).getSlug();
                Intent intent = new Intent(PhoneFavorisActivity.this,PhoneDetail.class);
                intent.putExtra("slug",s);
                startActivity(intent);
            }
        });
    }
}
