package com.example.usedbooks.repo;

import com.example.usedbooks.User;

/**
 * Created by Charmy PC on 2016-11-05.
 */

public class UserRepo {

    private User user;

    public UserRepo(){
        user = new User();
    }

    public static String createTable(){
        return "CREATE TABLE " + User.TABLE + "( " +
                User.KEY_UserId + " integer PRIMARY KEY autoincrement," +
                User.KEY_Name + " text not null," +
                User.KEY_Address + "text, " +
                User.KEY_Email + "text not null, " +
                User.KEY_Password + "text not null)";
    }

}
