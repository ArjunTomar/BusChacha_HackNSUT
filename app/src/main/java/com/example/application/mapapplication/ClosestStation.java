package com.example.application.mapapplication;

import android.util.Log;

import static android.icu.util.HebrewCalendar.AV;

public class ClosestStation {

    public static double a[][]=new double[8][2];

    ClosestStation()
    {}
    ClosestStation(int i,double LAT)
    {

        if(i%2==0){a[(i/2)%8][0]=LAT; }
        else {
        a[(((i-1)/2)%8)][1]=LAT;
        }

    }
    public static int cdK(double userlat,double userlog)
    { double min=1000000000;
       int pos=-1;
        for(int i=0;i<8;i++)
         { double latdist=Math.toRadians(userlat-a[i][0]);
           double logdist=Math.toRadians(userlog-a[i][1]);
           double A=Math.sin(latdist/2)*Math.sin(latdist/2)+Math.cos(Math.toRadians(userlat))*Math.cos(Math.toRadians(a[i][0])*Math.sin(logdist)*Math.sin(logdist/2));
           double c=2*Math.atan2(Math.sqrt(A),Math.sqrt(1-A));
           double val=(6371*c);
           if(val<min){min=val;pos=i;}
         }
       return pos;

    }
    double ret(double x)
    {
        return a[(int)x][0];
    }
    double ret1(double x)
    {
        return a[(int)x][1];
    }

}
