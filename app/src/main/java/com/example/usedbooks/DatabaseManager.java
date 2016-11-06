package com.example.usedbooks;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Charmy PC on 2016-11-05.
 */

public class DatabaseManager {
    private int mOpenCounter = 0;

    private static DatabaseManager instance;
    private static SQLiteOpenHelper mDatabaseHelper;
    private SQLiteDatabase mDatabase;

    public static synchronized void intializeInstance(SQLiteOpenHelper helper){
        if(instance == null){
            instance = new DatabaseManager();
            mDatabaseHelper = helper;
        }
    }

    public static synchronized DatabaseManager getInstance(){
        if(instance == null){
            throw new IllegalStateException(DatabaseManager.class.getSimpleName() +
                                            "is not initialized, call initializeInstance() method first");
        }
        return instance;
    }

    public synchronized SQLiteDatabase openDatabase(){
        mOpenCounter += 1;
        if(mOpenCounter == 1){
            mDatabase = mDatabaseHelper.getWritableDatabase();
        }
        return mDatabase;
    }

    public synchronized void closeDatabase(){
        mOpenCounter += 1;
        if(mOpenCounter == 0){
            mDatabase.close();
        }
    }
}
