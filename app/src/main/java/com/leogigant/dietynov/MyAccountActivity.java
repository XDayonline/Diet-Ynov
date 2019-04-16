package com.leogigant.dietynov;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;

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

        String date = cursor.getString(1);
        String size = cursor.getString(2);
        String weight = cursor.getString(3);
        String gender = cursor.getString(4);

        RadioButton buttonH = findViewById(R.id.my_account_h);
        RadioButton buttonF = findViewById(R.id.my_account_f);

        if(gender.equals("H")){
            buttonF.setChecked(false);
            buttonH.setChecked(true);
        }else{
            buttonF.setChecked(true);
            buttonH.setChecked(false);
        }

        Log.i("DATA","" + date);
        Log.i("DATA","" + size);
        Log.i("DATA","" + weight);

        birthView.setText(date);
        sizeView.setText(size);
        weightView.setText(weight);
    }
}