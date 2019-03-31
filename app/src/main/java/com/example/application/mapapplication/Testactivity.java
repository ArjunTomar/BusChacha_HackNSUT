package com.example.application.mapapplication;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Testactivity extends AppCompatActivity {

    int i=0;

    ClosestStation station;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testactivity);

//        vehicle v = new vehicle("he","er");
         // FirebaseDatabase.getInstance().getReference().child("smart-city-planner").child("BusStops").push().setValue(2.222);
//        FirebaseDatabase.getInstance().getReference().child("avhitej").push().setValue("dcsdvsdsd");
//        FirebaseDatabase.getInstance().getReference().child("avhitej").push().setValue("dcsdvssdgd");
//        FirebaseDatabase.getInstance().getReference().child("avhitej").push().setValue("dcsdvssdd");
//        FirebaseDatabase.getInstance().getReference().child("avhitej").push().setValue("dcsdvsdsd");
//        FirebaseDatabase.getInstance().getReference().child("avhitej").push().setValue("dcsdvewsd");
//
//        FirebaseDatabase.getInstance().getReference().addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    FirebaseDatabase.getInstance().getReference().child("avhitej").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                String data = dataSnapshot.getValue(String.class);
//                Log.d("hey",data);
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        //FirebaseDatabase.getInstance().getReference().child("dzczc").removeValue();
    }
}
