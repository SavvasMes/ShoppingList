package com.smeselidis.shoppinglist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLliteHelper extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME = "shopping_list.db";
    private static  final int DATABASE_VERSION = 1;

    public static final String TABLE_LISTS = "lists";
    public static final String LISTS_COLUMN_ID = "id";
    public static final String LISTS_COLUMN_NAME = "lname";

    public static final String TABLE_ITEMS = "items";
    public static final String ITEMS_COLUMN_ID = "id";
    public static final String ITEMS_COLUMN_INAME = "iname";
    public static final String ITEMS_COLUMN_DESCRIPTION = "description";


    public SQLliteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_LISTS+ "("+
                LISTS_COLUMN_ID+" integer primary key autoincrement," +
                LISTS_COLUMN_NAME+" text not null)");
        db.execSQL("CREATE TABLE "+ TABLE_ITEMS+ "("+
                ITEMS_COLUMN_ID+ "integer primary key autoincrement,"+
                ITEMS_COLUMN_INAME+ "text not null,"+
                ITEMS_COLUMN_DESCRIPTION+ "text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
