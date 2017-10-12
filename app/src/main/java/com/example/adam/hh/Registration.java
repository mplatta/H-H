package com.example.adam.hh;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void register(View view) {
        EditText e1 = (EditText)findViewById(R.id.editText);
        EditText e2 = (EditText)findViewById(R.id.editText3);
        if(findViewById(R.id.editText).toString().isEmpty() || findViewById(R.id.editText3).toString().isEmpty() || findViewById(R.id.editText2).toString().isEmpty()){
            //if any field is empty
        }
        else if(false){
            //If login is in database yet
        }
        else if(e1.getText().toString().equals( e2.getText().toString())){
            //If passwords are the same
        }
    }
}
