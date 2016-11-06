package com.example.usedbooks;

/**
 * Created by Charmy PC on 2016-11-05.
 */

public class User {
    public static final String TAG = User.class.getSimpleName();
    public static final String TABLE = "User";

    public static final String KEY_UserId = "UserId";
    public static final String KEY_Name = "Name";
    public static final String KEY_Address = "Address";
    public static final String KEY_Email = "Email";
    public static final String KEY_Password = "Password";

    public int userId;
    public String name;
    public String address;
    public String email;
    public String password;

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
