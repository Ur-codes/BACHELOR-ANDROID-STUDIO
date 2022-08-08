package com.example.testapp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE FAVORIS (slug TEXT PRIMARY KEY,name TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int new_v) {

        db.execSQL("DROP TABLE FAVORIS");
        onCreate(db);

    }
}
