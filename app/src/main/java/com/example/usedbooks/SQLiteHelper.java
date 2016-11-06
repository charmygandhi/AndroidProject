package com.example.usedbooks;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.usedbooks.repo.BooksRepo;
import com.example.usedbooks.repo.CategoryRepo;
import com.example.usedbooks.repo.UserRepo;

/**
 * Created by Charmy PC on 2016-11-05.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BooksDatabase.db";

    public SQLiteHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CategoryRepo.createTable());
        db.execSQL(UserRepo.createTable());
        db.execSQL(BooksRepo.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.d(DATABASE_NAME, String.format("BookDatabase.onUpgrade(%d -> %d)", i, i1));

        db.execSQL("DROP TABLE IF EXISTS " + Category.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Books.TABLE);
        onCreate(db);
    }
}
