package com.example.testapp2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ordinateur_detail extends AppCompatActivity {

    private TextView tv1,tv2,tv3;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordinateur_detail);


        this.tv1 = findViewById(R.id.detailmarque);
        this.tv2 = findViewById(R.id.detailmodel);
        this.tv3 = findViewById(R.id.detailram);

        String t_marque = getIntent().getStringExtra("marque");
        String t_modele = getIntent().getStringExtra("modele");
        int t_ram = getIntent().getIntExtra("ram",0);

        tv1.setText("Marque : " + t_marque);
        tv2.setText("Modele : " + t_modele);
        tv3.setText("RAM : " + Integer.toString(t_ram));


    }
}
