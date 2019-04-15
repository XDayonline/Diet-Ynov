package com.leogigant.dietynov;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MyAccountActivity extends AppCompatActivity {
    private DatabaseManager databaseManager;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        databaseManager = new DatabaseManager(this);
        cursor = databaseManager.getAccount();

        EditText sizeView = (EditText) this.findViewById(R.id.parameter_size_v);
        EditText birthView = (EditText) this.findViewById(R.id.parameter_birth_v);
        EditText weightView = (EditText) this.findViewById(R.id.parameter_weigth_v);

        String birth = cursor.getString(1);
        String size = cursor.getString(2);
        String weight = cursor.getString(3);

        Log.i("DATA","" + birth);
        Log.i("DATA","" + size);
        Log.i("DATA","" + weight);

        birthView.setText(birth);
        sizeView.setText(size);
        weightView.setText(weight);
    }
}