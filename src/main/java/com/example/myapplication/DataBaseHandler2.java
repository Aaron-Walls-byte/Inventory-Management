package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.data.model.User;
import com.example.myapplication.ui.home.InventoryItem;


public class DataBaseHandler2 extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Item";

    //Table Names
    private static final String TABLE_ITEMS = "items";

    //User Members

    //Item Members
    private static final String ITEM_ID = "item_id";
    private static final String ITEM_NAME = "item_name";
    private static final String ITEM_COUNT = "item_count";


    public DataBaseHandler2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_ITEMS + "("
                + ITEM_ID + " INTEGER PRIMARY KEY," + ITEM_NAME + " TEXT,"
                + ITEM_COUNT + " INTEGER" + ")";
        db.execSQL(CREATE_ITEM_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);

        // Create tables again
        onCreate(db);
    }
    public void addItem(Items item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ITEM_NAME, item.getItem()); // Item Name
        values.put(ITEM_COUNT, item.getCount()); // Item Count

        // Inserting Row
        db.insert(TABLE_ITEMS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    public Items getItem(String item) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ITEMS, new String[] {ITEM_ID,
                        ITEM_NAME, ITEM_COUNT}, ITEM_NAME + "=?",
                new String[] { item }, null, null, null, null);
        Items items = null;
        if(cursor.moveToFirst()){
            items = new Items(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        }
        cursor.close();

        // return contact
        return items;
    }
    public List<Items> getAllItems() {
        List<Items> itemList = new ArrayList<Items>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Items item = new Items();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setItem(cursor.getString(1));
                item.setCount(Integer.parseInt(cursor.getString(2)));
                // Adding contact to list
                itemList.add(item);
            } while (cursor.moveToNext());
        }

        // return contact list
        return itemList;
    }
    // code to update the single contact
    public int updateItem(Items item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ITEM_NAME, item.getItem());
        values.put(ITEM_COUNT, item.getCount());

        // updating row
        return db.update(TABLE_ITEMS, values, ITEM_ID + " = ?",
                new String[] { String.valueOf(item.getId()) });
    }
    public void deleteItem(Items item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, ITEM_ID + " = ?",
                new String[] { String.valueOf(item.getId()) });
        db.close();
    }

    public int getItemCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ITEMS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        //cursor.close();

        // return count
        return cursor.getCount();
    }
}