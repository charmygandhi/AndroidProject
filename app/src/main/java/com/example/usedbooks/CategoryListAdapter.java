package com.example.usedbooks;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Charmy PC on 2016-11-06.
 */

public class CategoryListAdapter extends ArrayAdapter<Category> {
    private Context context;
    List<Category> categories;

    public CategoryListAdapter(Context context,List<Category> categories){
        super(context,R.layout.category_display,categories);
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Nullable
    @Override
    public Category getItem(int position) {
        return categories.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.category_display,null);

            textView = (TextView)convertView.findViewById(R.id.txtCategoryName);

        }
        else{
            textView = (TextView)convertView.getTag();
        }

        Category category = getItem(position);
        textView.setText(category.getName());

        return convertView;
    }
}
