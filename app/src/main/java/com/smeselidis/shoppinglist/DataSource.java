package com.smeselidis.shoppinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DataSource {

    private SQLiteDatabase database;
    private SQLliteHelper dbHelper;

    private String[] listCollum = {SQLliteHelper.LISTS_COLUMN_ID, SQLliteHelper.LISTS_COLUMN_NAME, SQLliteHelper.LISTS_COLUMN_FAV};
    private  String[] itemCollum = {SQLliteHelper.ITEMS_COLUMN_ID, SQLliteHelper.ITEMS_COLUMN_INAME, SQLliteHelper.ITEMS_COLUMN_DESCRIPTION};

    public DataSource(Context context){
        dbHelper = new SQLliteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<List> selectList() {
        ArrayList<List> lists = new ArrayList<>();
        Cursor cursor = database.query("lists", listCollum, null, null, null,null, null
        );


        return lists;
    }

    public void insertList(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put("lname", name);
        database.insert("lists", null, contentValues);
    }


}
