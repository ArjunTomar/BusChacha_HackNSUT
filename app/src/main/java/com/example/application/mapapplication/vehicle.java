package com.example.application.mapapplication;

public class vehicle {
    String name,tyre;
    public vehicle(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

    public vehicle(String name, String tyre) {
        this.name = name;
        this.tyre = tyre;
    }
}
