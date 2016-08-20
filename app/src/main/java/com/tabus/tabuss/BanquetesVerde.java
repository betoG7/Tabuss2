package com.tabus.tabuss;

import android.app.NotificationManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
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
 * Created by Humberto on 25/04/2015.
 */
public class BanquetesVerde extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private CameraUpdate cameraUpdate;

    Principio p=new Principio();

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


                      //  Toast.makeText(this, resultados + " " + resultado + "" + q, Toast.LENGTH_SHORT).show();
                        //  String a = sm.a;
                        latitud= Double.parseDouble(llenado[1]);
                        longitud= Double.parseDouble(llenado[3]);


                        mMap.addPolyline(new PolylineOptions().geodesic(true)
                                        .add(new LatLng(20.364104, -102.042852)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.362404, -102.044311)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.359970, -102.048764)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.353306, -102.049998)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.350869, -102.041254)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.347921, -102.030675)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.346591, -102.031131)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.345370, -102.031683)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.344613, -102.031973)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.344083, -102.032215)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.344067, -102.032182)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343595, -102.032394)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343151, -102.030552)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343159, -102.025708)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343048, -102.025461)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343058, -102.024077)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340840, -102.024040)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340689, -102.023197)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340578, -102.023203)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.339799, -102.021749)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.338898, -102.020204)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.338798, -102.020032)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.337133, -102.018552)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.337022, -102.018568)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.336625, -102.018380)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.336519, -102.018493)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.336026, -102.020698)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.334930, -102.020252)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.334467, -102.020091)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.332736, -102.019453)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.332243, -102.019314)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.330810, -102.018874)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.327706, -102.018820)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.327590, -102.019517)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.326750, -102.020440)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.326481, -102.020799)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.325646, -102.021094)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.325596, -102.021035)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.324569, -102.021438)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.324625, -102.019845)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.324640, -102.019673)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.324127, -102.018798)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.324091, -102.018621)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.323749, -102.018552)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.323634, -102.018310)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.323930, -102.017243)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.324574, -102.017050)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.325188, -102.017173)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.326395, -102.017382)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.327381, -102.017050)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.328488, -102.016803)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.329353, -102.016519)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.336403, -102.018321)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.337449, -102.017785)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.338556, -102.017506)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.340125, -102.017484)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.341876, -102.018385)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.342077, -102.019330)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.341694, -102.020102)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343641, -102.023975)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.343802, -102.025230)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.346508, -102.026024)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.347001, -102.026808)).width(10).color(Color.GREEN)
                                        .add(new LatLng(20.347936, -102.030756)).width(10).color(Color.GREEN)


                        );


                        mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud))
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp)));

                        //Paradas();
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.364104, -102.042852))
                                .title("Inicio de ruta")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start))
                                .snippet("Tecnológico de La Piedad"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.350110, -102.038511))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Bodega Aurrera y Puente de Bodega Aurrera"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.348166, -102.031722))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("La Central"));



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
                                .position(new LatLng(20.341794, -102.020209))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Los Puentes"));






                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.341517, -102.024073))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Mercado"));
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.340204, -102.022465))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Farmacia Similares"));


                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.332799, -102.017393))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Lic. Rafael Reyes"));


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

    double lat= p.getLat();
    double longi=p.getLongi();

    private void setUpMap() {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(20.35474358, -102.05581295)).title("Marker"));
        cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 15);
        mMap.animateCamera(cameraUpdate);
    }


}


