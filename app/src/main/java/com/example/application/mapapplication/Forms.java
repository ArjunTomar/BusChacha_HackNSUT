package com.example.application.mapapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Forms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        }
     public void FormSubmit(View view)
     {

         Toast one =Toast.makeText(this,"Thanks For Your Response",Toast.LENGTH_LONG);
         one.show();
         Intent i = new Intent(Forms.this,MapsActivity.class);
         startActivity(i);

     }

}
