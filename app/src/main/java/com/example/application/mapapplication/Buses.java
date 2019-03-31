
package com.example.application.mapapplication;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Buses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Double LAT;
        Double LONG;
        Bundle extras= getIntent().getExtras();

            String s1 = extras.getString("key");
            String s2= extras.getString("key1");

            LAT=Double.parseDouble(s1);
            LONG=Double.parseDouble(s2);


            LAT+=28.6193;
            LONG+=77.0333;



        Geocoder geocoder;
        List<Address> addresses = null;
        geocoder = new Geocoder(this, Locale.getDefault());


        try {
            addresses = geocoder.getFromLocation(LAT, LONG, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
         }
        catch (IOException e) {
            e.printStackTrace();
        }


        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
        String city = addresses.get(0).getLocality();
        String state = addresses.get(0).getAdminArea();
        String country = addresses.get(0).getCountryName();
        String postalCode = addresses.get(0).getPostalCode();
        String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

        TextView myText = (TextView)findViewById(R.id.myText);
        myText.setText(address+"\n"+city+"\n"+state+"\n"+country+"\n"+postalCode+"\n"+knownName);

    }

    public void surveyB(View view)
    {
        Intent i=new Intent(Buses.this,Forms.class);
        startActivity(i);
    }


}
