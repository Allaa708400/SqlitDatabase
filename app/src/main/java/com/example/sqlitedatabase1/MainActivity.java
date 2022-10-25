package com.example.sqlitedatabase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.sqlitdatabase.R;

import java.util.ArrayList;
@SuppressLint({"MissingInflatedId", "LocalSuppress"})
public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv_main);
        ArrayList<Car> cars = new ArrayList<>();

      DatabaseAccess db = DatabaseAccess.getInstance(this);
      db.open();
      cars = db.getAllCars();
      db.close();


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(cars);
        //RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        RecyclerView.LayoutManager lm = new GridLayoutManager(this,5);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

    }
        }
