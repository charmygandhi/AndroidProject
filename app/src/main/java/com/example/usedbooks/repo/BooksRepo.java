package com.example.usedbooks.repo;

import com.example.usedbooks.Books;
import com.example.usedbooks.Category;
import com.example.usedbooks.User;

/**
 * Created by Charmy PC on 2016-11-05.
 */

public class BooksRepo {

    private Books books;

    public BooksRepo(){
        books = new Books();
    }

    public static String createTable() {
        return "CREATE TABLE " + Books.TABLE + "(" +
                Books.KEY_BookId + " integer PRIMARY KEY autoincrement," +
                Books.KEY_Title + " text not null," +
                Books.KEY_Price + " integer not null," +
                Books.KEY_Description + " text" +
                Books.KEY_Image + " text not null," +
                Books.KEY_CategoryId + " integer," +
                Books.KEY_UserId + " integer," +
                "FOREIGN KEY(" + Books.KEY_CategoryId + ") REFERENCES " +
                Category.TABLE + "( " + Category.KEY_CategoryId + ")," +
                "FOREIGN KEY( " + Books.KEY_UserId + ") REFERENCES " +
                 User.TABLE + "( " + User.KEY_UserId + "))";


    }
}
