package com.example.androidstudioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    private Button buttonE;
    private Button buttonR;
    private EditText edittext;
    private CheckBox checkBox;
    private Integer integer;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        this.buttonE = findViewById(R.id.BE);
        this.edittext = findViewById(R.id.ET2);
        this.checkBox = findViewById(R.id.CB);





        SharedPreferences settings = getSharedPreferences( "mydictionnary" , Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = settings.edit();

        this.edittext.setText(settings.getString("pseudo",null));
        this.checkBox.setChecked(settings.getBoolean("majeur",false));
        this.integer = settings.getInt("integer",0);
        integer ++;
        edit.putInt("integer",integer.intValue());
        edit.apply();


        this.textView = findViewById(R.id.COMPTEUR);
        this.textView.setText(integer.toString());


                this.buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!edittext.getText().toString().isEmpty()) {
                    edit.putString("pseudo", edittext.getText().toString());
                    edit.putBoolean("majeur", checkBox.isChecked());

                    edit.apply();
                }
                else {
                    edittext.setError("Saisie obligatoire");
                }

            }
        });

        this.buttonR = findViewById(R.id.BR);
        this.buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(settings.getString("pseudo",edittext.getText().toString()) != null) {
                    new AlertDialog.Builder(SettingActivity.this)
                            .setTitle("Suppression")
                            .setMessage("Voulez vous supprimer ?")
                            .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    edit.remove("pseudo");
                                    edit.remove("majeur");
                                    edit.apply();

                                }
                            }).setNegativeButton("Non", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).setCancelable(false)
                            .show();


                }
                else{

                    Toast.makeText(SettingActivity.this , "Erreur les clés n'existent pas !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}