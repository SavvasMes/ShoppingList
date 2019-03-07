package com.smeselidis.shoppinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


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

    public ArrayList<List> selectLists() {
        ArrayList<List> lists = new ArrayList<>();
        Cursor cursor = database.query("lists", listCollum, null, null, null,null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            lists.add(this.cursorToList(cursor));
            cursor.moveToNext();
        }

        return lists;
    }

    public List selectList(String id){
        Cursor cursor = database.query("lists", listCollum, "id = ?", new String[] { id }, null, null, null);
        cursor.moveToFirst();
        return this.cursorToList(cursor);

    }

    public void insertList(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put("lname", name);
        //contentValues.put("fav", fav);
        database.insert("lists", null, contentValues);
    }

    private List cursorToList(Cursor cursor){
        List list = new List();
        list.setId(cursor.getInt(0));
        list.setName(cursor.getString(1));
        list.setFav(cursor.getInt(2));

        return list;
    }

    public void insertItem (String name, String description){
        ContentValues contentValues = new ContentValues();
        contentValues.put("iname", name);
        contentValues.put("description", description);
        database.insert("items", null, contentValues);
    }


}
