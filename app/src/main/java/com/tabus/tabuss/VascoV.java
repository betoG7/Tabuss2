package com.tabus.tabuss;

import android.app.NotificationManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.StringTokenizer;

import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by Humberto on 07/05/2015.
 */
public class VascoV extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private CameraUpdate cameraUpdate;
    LocationManager locationManager;
    Principio pri=new Principio();
    SMSReceiver smsre=new SMSReceiver();
    double lt= smsre.getLati();
    double ln= smsre.getLongi();

    double latitud, longitud;

    cursoQL ch = new cursoQL(this, "BD", null, 1);

    String resultados="";
    String resultado="";
    String llenado[];
    int vari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();


        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notificationManager.cancelAll();

        Timer timer =  new  Timer ();
        timer . schedule ( new  TimerTask ()  {
            @Override
            public  void run ()  {

                runOnUiThread ( new  Runnable (){
                    @Override
                    public  void run (){
                        //
                        resultados="";
                        SQLiteDatabase op = ch.getReadableDatabase();
                        Cursor cursor = op.rawQuery("SELECT * FROM gpscamionz ORDER BY id DESC LIMIT 1", null);
                        if (cursor.moveToFirst()) {
                            do {
                                resultados += "" + cursor.getString(1);
                                // resultado += "" + cursor.getString(2);
                                //  q=""+cursor.getString(3);
                            }
                            while (cursor.moveToNext());

                        }
                        vari= resultados.length();
                        llenado=new String[vari];
                        int a=0;
                        StringTokenizer tokens =new StringTokenizer(resultados,": ");
                        while(tokens.hasMoreTokens()){
                            if(a<vari){
                                llenado[a]=tokens.nextToken();
                                a++;
                            }
                        }


                   //     Toast.makeText(this, resultados + " " + resultado + "" + q, Toast.LENGTH_SHORT).show();
                        //  String a = sm.a;
                        latitud= Double.parseDouble(llenado[1]);
                        longitud= Double.parseDouble(llenado[3]);


                        mMap.addPolyline(new PolylineOptions().geodesic(true)
                                        .add(new LatLng(20.350324, -102.039074)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.352263, -102.038586)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.352338, -102.038495)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.356246, -102.041858)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.354370, -102.043494)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.353530, -102.040420)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.351664, -102.040973)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.350880, -102.041177)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.351187, -102.042277)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.346854, -102.026505)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.346180, -102.025883)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343956, -102.025379)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343745, -102.025164)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343655, -102.024113)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340858, -102.024016)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340757, -102.024102)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339409, -102.024166)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339470, -102.024960)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339389, -102.025625)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339621, -102.027224)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340413, -102.030807)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340101, -102.030947)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340031, -102.030925)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339427, -102.031194)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339387, -102.031280)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.338808, -102.031537)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339492, -102.034042)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340453, -102.034911)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.341454, -102.038591)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339603, -102.039170)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339492, -102.039149)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.336474, -102.040190)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.335559, -102.036939)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.333154, -102.037690)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.332812, -102.036671)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.336535, -102.035523)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339120, -102.034675)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339885, -102.034814)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340468, -102.035072)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340388, -102.034836)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339613, -102.034299)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339178, -102.032904)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.338806, -102.031531)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339419, -102.031263)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339465, -102.031161)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339761, -102.031048)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339263, -102.028977)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.341482, -102.028275)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.341014, -102.025582)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340923, -102.025110)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340833, -102.024021)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340697, -102.023184)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.341461, -102.023120)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.342055, -102.023012)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.342523, -102.023313)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343458, -102.024058)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343665, -102.024112)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343685, -102.024584)).width(10).color(Color.GREEN)


                        );

                        mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud))
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp)));


                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.350110, -102.038511))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Bodega Aurrera y Puente de Bodega Aurrera"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.353535, -102.040437))
                                .title("Inicio Ruta")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start))
                                .snippet("Vasco Linea Verde"));
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.341184, -102.038699))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Lasalle"));
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.348166, -102.031722))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("La Central"));
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.347516, -102.029217))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Gasolinera"));
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.347185, -102.027390))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("La Marina"));
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.344163, -102.025596))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("La Purisima"));
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.341517, -102.024073))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Mercado"));
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.342514, -102.023239))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Aquiles Serdan"));
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.340850, -102.023163))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Señor de La Piedad"));


                    }
                });

            }
        },  0 ,  5000 );



    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
                setUpMap();


            }
        }
    }

    double lat=pri.getLat();
    double longi = pri.getLongi();

    private void setUpMap() {

        //mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Marker"));20.349577, -102.036094
        //cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(20.349577, -102.036094),15);
        cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 15);
        mMap.animateCamera(cameraUpdate);
    }
}
