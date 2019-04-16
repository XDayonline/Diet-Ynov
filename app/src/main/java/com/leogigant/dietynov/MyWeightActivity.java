package com.leogigant.dietynov;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MyWeightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_weight);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DatabaseManager databaseManager = new DatabaseManager(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText weightText = findViewById(R.id.add_weight_v);
                Float weightValue = Float.valueOf(weightText.getText().toString());

                Log.i("DATA", "weight : " + weightValue);;
                databaseManager.addWeight(weightValue);
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final ListView myList = (ListView) findViewById(R.id.weight_list);
        ArrayList<Weight> myWeights = databaseManager.getWeight();

        ArrayAdapter adapter = new WeightAdapter(this, myWeights);
        myList.setAdapter(adapter);
    }
}
