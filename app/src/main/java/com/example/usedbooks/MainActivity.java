package com.example.usedbooks;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usedbooks.repo.CategoryRepo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CategoryRepo categoryRepo;
    private SQLiteDatabase db;
    private static SQLiteHelper dbHelper;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this.getApplicationContext();
        dbHelper = new SQLiteHelper(context);
        DatabaseManager.intializeInstance(dbHelper);


        categoryRepo = new CategoryRepo(this);

        Cursor categoryCursor = db.rawQuery("Select * FROM " + Category.TABLE ,null);
        ListView listView = (ListView)findViewById(R.id.list);
        CategoryCursorAdapter categoryCursorAdapter = new CategoryCursorAdapter(this,categoryCursor);
        listView.setAdapter(categoryCursorAdapter);

        /*List<String> values = categoryRepo.getAllCategory();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);*/

        Button btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText text = (EditText)findViewById(R.id.editText);
        Category category = new Category();
        category.setName(text.getText().toString());
        categoryRepo.insert(category);
        String name = category.getName();
        Toast.makeText(MainActivity.this,name+ " " ,Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        db = DatabaseManager.getInstance().openDatabase();

    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseManager.getInstance().closeDatabase();
    }

    public class CategoryCursorAdapter extends CursorAdapter{
        public CategoryCursorAdapter(Context context, Cursor cursor){
            super(context,cursor,0);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            return LayoutInflater.from(context).inflate(R.layout.category_display,null,false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView txtName = (TextView)view.findViewById(R.id.txtCategoryName);

            String name = cursor.getString(cursor.getColumnIndex(Category.KEY_Name));
            txtName.setText(name);
        }
    }
}
