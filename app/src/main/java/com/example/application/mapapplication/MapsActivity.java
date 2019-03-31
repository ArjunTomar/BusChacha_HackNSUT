package com.example.application.mapapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,LocationListener {

    private GoogleMap mMap;
     Button search;
    double LA,LA1;
double x,y;
    int i=0;
    ClosestStation station;

    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        search=(Button)findViewById(R.id.ic_magnify);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                EditText editText = (EditText) findViewById(R.id.input_search);
                String address = editText.getText().toString();

                GeocodingLocation locationAddress = new GeocodingLocation();
                locationAddress.getAddressFromLocation(address,
                        getApplicationContext(), new GeocoderHandler());

            }
        });
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }

        station=new ClosestStation();
        FirebaseDatabase.getInstance().getReference().child("BusStops").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Double data = dataSnapshot.getValue(Double.class);
                station= new ClosestStation(i,data);
                i++;
                }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void sendLocation(View view)
    {
        Intent i= new Intent(MapsActivity.this,Buses.class);
        i.putExtra("key",String.valueOf(x));
        i.putExtra("key1",String.valueOf(y));
        startActivity(i);
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
       if(i==0) {
           LatLng Destination1 = new LatLng(location.getLatitude(), location.getLongitude());
           mMap.addMarker(new MarkerOptions().position(Destination1).title("Your Source"));
           mMap.moveCamera(CameraUpdateFactory.newLatLng(Destination1));
           mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Destination1, 20.0f));
           x= station.cdK(location.getLatitude(), location.getLongitude());
           y=station.ret1(x);
           x=station.ret(x);
           i++;
       }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(MapsActivity.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            String locationAddress1;



            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    locationAddress1 = bundle.getString("address1");
                    LA=Double.parseDouble(locationAddress);
                    LA1=Double.parseDouble(locationAddress1);
                    MyFunc(mMap);
                    break;
                default:
                    locationAddress = null;
                    locationAddress1 = null;
            }

        }
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    public void MyFunc(GoogleMap googleMap) {


        // Add a marker in Sydney and move the camera
       /* LatLng India  = new LatLng(19.085435,  72.858546);
        mMap.addMarker(new MarkerOptions().position(India).title("How's the Josh"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(India));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(India,12.0f));*/

        LatLng Destination  = new LatLng(LA,LA1);
        mMap.addMarker(new MarkerOptions().position(Destination).title("Your Destination"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Destination));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Destination,20.0f));

    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
       /* LatLng India  = new LatLng(19.085435,  72.858546);
        mMap.addMarker(new MarkerOptions().position(India).title("How's the Josh"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(India));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(India,12.0f));*/

        getLocation();

    }
}
