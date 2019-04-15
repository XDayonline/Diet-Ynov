package com.leogigant.dietynov;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class createAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void createAccount(View view) throws ParseException {
        try {
            TextView size = findViewById(R.id.account_size_v);
            TextView birthDate = findViewById(R.id.account_birth_v);
            TextView startWeight = findViewById(R.id.account_start_weight_v);
            RadioGroup genderChecked = findViewById(R.id.account_gender_group_v);

            genderChecked.getCheckedRadioButtonId();
            RadioButton gender = findViewById(genderChecked.getCheckedRadioButtonId());

            int sizeValue = Integer.parseInt(size.getText().toString());
            Date dateValue = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate.getText().toString());
            float startWeightValue = Float.parseFloat(startWeight.getText().toString());
            String genderValue = gender.getText().toString();

            Log.i("DATA", "gender : " + genderValue);
             DatabaseManager databaseManager = new DatabaseManager(this);
             databaseManager.createAccount(sizeValue, dateValue, startWeightValue, genderValue);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }catch (Exception exeption){
            Log.i("Erreur", " " + exeption);
        }
    }
}