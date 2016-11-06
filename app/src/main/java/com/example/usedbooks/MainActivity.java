package com.example.usedbooks;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.usedbooks.repo.CategoryRepo;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private CategoryRepo categoryRepo;
    private SQLiteDatabase db;
    private static SQLiteHelper dbHelper;
    private static Context context;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this.getApplicationContext();
        dbHelper = new SQLiteHelper(context);
        DatabaseManager.intializeInstance(dbHelper);

        categoryRepo = new CategoryRepo(this);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        loadSpinnerData();

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

    private void loadSpinnerData(){
        List<String> name = categoryRepo.getAllCategory();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,name);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String name = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),"You selected: " + name,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
