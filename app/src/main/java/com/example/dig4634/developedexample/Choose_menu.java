package com.example.dig4634.developedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Choose_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_menu);
    }

    public void onLeveloneClick(View view){
        Intent one=new Intent(getBaseContext(),GameActivity.class);
        startActivity(one);
    }

    public void onLeveltwoClick(View view){
        Intent two=new Intent(getBaseContext(),GameActivity.class);
        startActivity(two);
    }

    public void onLevelthreeClick(View view){
        Intent three=new Intent(getBaseContext(),GameActivity.class);
        startActivity(three);
    }

}