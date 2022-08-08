package com.example.testapp3;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testapp3.objects.PhoneFav;

import java.util.ArrayList;
import java.util.List;

public class DBPhone {

    private int version = 1;
    private DBHelper helper;
    private SQLiteDatabase bdd;

    public DBPhone(Context context) {
        this.helper = new DBHelper(context,"favoris.db",null,this.version);
    }

    public void open(){
        this.bdd = this.helper.getWritableDatabase();
    }

    public void close(){
        this.bdd.close();
    }

    public long insertFavori(PhoneFav pf){
        ContentValues contentValues = new ContentValues();
        contentValues.put("slug",pf.getSlug());
        contentValues.put("name",pf.getName());
        return this.bdd.insert("FAVORIS",null,contentValues);
    }

    @SuppressLint("Range")
    public List<PhoneFav> getFavoris(){

        List<PhoneFav> res = new ArrayList<>();
        Cursor cursor = this.bdd.rawQuery("SELECT * FROM FAVORIS",null);
        while (cursor.moveToNext()){
            PhoneFav current = new PhoneFav();
            current.setSlug(cursor.getString(cursor.getColumnIndex("slug")));
            current.setName(cursor.getString(cursor.getColumnIndex("name")));
            res.add(current);
        }
        return res;
    }
}
