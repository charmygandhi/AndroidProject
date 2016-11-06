package com.example.usedbooks.repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usedbooks.Category;
import com.example.usedbooks.DatabaseManager;
import com.example.usedbooks.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charmy PC on 2016-11-05.
 */

public class CategoryRepo {

    private Category category;
    SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
    private SQLiteHelper dbHelper;
    private String[] Category_Columns = { Category.KEY_CategoryId,Category.KEY_Name };

    public CategoryRepo(Context context){
        category = new Category();
        dbHelper = new SQLiteHelper(context);
    }

    public static String createTable(){
       return "CREATE TABLE " + Category.TABLE + "(" +
               Category.KEY_CategoryId + " integer PRIMARY KEY autoincrement ," +
               Category.KEY_Name + " text not null)";
    }

    public long insert(Category category){
        long categoryId;

        ContentValues values = new ContentValues();
        values.put(Category.KEY_Name,category.getName());

        //inserting row
        categoryId = db.insert(Category.TABLE,null,values);
        DatabaseManager.getInstance().closeDatabase();
        return categoryId;
    }

    public void delete(Category category){
        long id = category.getCategoryId();

        db.delete(Category.TABLE,Category.KEY_CategoryId + "=" + id,null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public List<String> getAllCategory(){
        List categories = new ArrayList();

        Cursor cursor = db.query(Category.TABLE,Category_Columns,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            category = parseCategory(cursor);
            categories.add(category);
            cursor.moveToNext();
        }

        cursor.close();
        return categories;
    }

    private Category parseCategory(Cursor cursor){
        Category category = new Category();
        category.setCategoryId((cursor.getInt(0)));
        category.setName((cursor.getString(1)));
        return category;
    }
}
