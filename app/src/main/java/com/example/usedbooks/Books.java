package com.example.usedbooks;

/**
 * Created by Charmy PC on 2016-11-05.
 */

public class Books {
    public static final String TAG = Books.class.getSimpleName();
    public static final String TABLE = "Books";

    public static final String KEY_BookId = "BookId";
    public static final String KEY_Title = "Title";
    public static final String KEY_Price = "Price";
    public static final String KEY_Description = "Description";
    public static final String KEY_Image = "Image";
    public static final String KEY_CategoryId = "CategoryId";
    public static final String KEY_UserId = "UserId";

    public int bookId;
    public String title;
    public int price;
    public String description;
    public String image;
    public String categoryId;
    public String userId;

    public int getBookId(){
        return bookId;
    }

    public void setBookId(int bookId){
        this.bookId = bookId;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(String categoryId){
        this.categoryId = categoryId;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(){
        this.userId = userId;
    }
}
