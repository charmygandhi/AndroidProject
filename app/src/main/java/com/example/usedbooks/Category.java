package com.example.usedbooks;

/**
 * Created by Charmy PC on 2016-11-05.
 */

public class Category {
    public static final String TAG = Category.class.getSimpleName();
    public static final String TABLE = "Category";

    public static final String KEY_CategoryId = "CategoryId";
    public static final String KEY_Name = "Name";

    private int categoryId;
    private String name;

    public int getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(int categoryId){
        this.categoryId = categoryId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
