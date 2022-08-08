package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lv = findViewById(R.id.list_ordi);

        OrdinateurAdapter oadap = new OrdinateurAdapter(getOrdinateurs(),MainActivity.this);
        this.lv.setAdapter(oadap);

        this.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent in = new Intent(MainActivity.this, Ordinateur_detail.class);
                in.putExtra("marque", getOrdinateurs().get(i).getMarque().toString());
                in.putExtra("modele", getOrdinateurs().get(i).getModele().toString());
                in.putExtra("ram", getOrdinateurs().get(i).getRam());

                startActivity(in);
            }
        });


    }

    public  List<Ordinateur> getOrdinateurs(){
        List<Ordinateur> resultat = new ArrayList<Ordinateur>();
        resultat.add(new Ordinateur("ASUS","test",12));
        resultat.add(new Ordinateur("Apple","9999",21));
        resultat.add(new Ordinateur("HP","0001",10));

        return resultat;
    }
}