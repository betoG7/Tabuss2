package com.tabus.tabuss.Rutas;

import android.app.NotificationManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.tabus.tabuss.Principio;
import com.tabus.tabuss.R;
import com.tabus.tabuss.SMSReceiver;
import com.tabus.tabuss.cursoQL;

import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Humberto on 07/05/2015.
 */
public class Lienzo extends FragmentActivity {

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
    double lat = Principio.getLat();
    double longi = Principio.getLongi();
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private CameraUpdate cameraUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notificationManager.cancelAll();
        String q="";

        Timer timer =  new  Timer ();
        timer . schedule ( new  TimerTask()  {
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


                       // Toast.makeText(this, resultados + " " + resultado + "" + q, Toast.LENGTH_SHORT).show();
                        //  String a = sm.a;
                        latitud= Double.parseDouble(llenado[1]);
                        longitud= Double.parseDouble(llenado[3]);


                        mMap.addPolyline(new PolylineOptions().geodesic(true)
                                        .add(new LatLng(20.360045, -102.071396)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.355529, -102.058223)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.354141, -102.053095)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.351918, -102.056700)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.350359, -102.050917)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.352250, -102.050338)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.350681, -102.044630)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.344243, -102.046625)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.344791, -102.048739)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.342880, -102.049211)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.342211, -102.045563)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.343640, -102.045134)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.343931, -102.046207)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.346144, -102.045507)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.346205, -102.045668)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.346491, -102.045577)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.345848, -102.043361)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.346406, -102.042782)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.343594, -102.032455)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.343303, -102.031259)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.342055, -102.031801)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.341351, -102.027445)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.341029, -102.025600)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.340923, -102.025095)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.340707, -102.023196)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.340576, -102.023202)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.339807, -102.021748)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.339832, -102.021646)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.338866, -102.020187)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.338841, -102.020080)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.338001, -102.019382)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.337936, -102.019264)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.337121, -102.018556)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.336628, -102.018374)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.336512, -102.018502)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.336027, -102.020712)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.336761, -102.020959)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.335400, -102.022869)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.335784, -102.024320)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.335022, -102.024808)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.335457, -102.026745)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.335862, -102.026584)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.336181, -102.027949)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.335759, -102.028129)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.336113, -102.029703)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.336337, -102.029604)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.336552, -102.030154)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.337246, -102.030344)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.337613, -102.031986)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.338370, -102.031669)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.337891, -102.029368)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.337625, -102.028644)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.337081, -102.026450)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.337081, -102.026063)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.337273, -102.024856)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.340610, -102.023198)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.341435, -102.023145)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.341576, -102.024041)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.342310, -102.027275)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.342642, -102.028461)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.342879, -102.029673)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.343150, -102.030574)).width(10).color(Color.BLUE)
                                        .add(new LatLng(20.343311, -102.031347)).width(10).color(Color.BLUE)


                        );


                        mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud))
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp)));


                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.360045, -102.071396))
                                .title("Inicio Ruta")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start))
                                .snippet("Lienzo Charro"));


                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.355160, -102.056921))
                                .title("Parada Oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Wal-Mart"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.347231, -102.045741))
                                .title("Parada ")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet(""));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.346495, -102.045570))
                                .title("Parada ")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet(""));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.346402, -102.042772))
                                .title("Parada Oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Mariano Jimenez"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.344736, -102.036548))
                                .title("Parada Oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Leo's Pizza"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.343263, -102.031317))
                                .title("Parada Oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Dolphy"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.340821, -102.024220))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet(""));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.336695, -102.018437))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("La Glorieta"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.336760, -102.021007))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Santuario"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.340850, -102.023163))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Señor de La Piedad"));







                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.340204, -102.022465))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Farmacia Similares"));




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

    private void setUpMap() {

        //mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Marker"));20.349577, -102.036094
        //cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(20.349577, -102.036094),15);
        cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 15);
        mMap.animateCamera(cameraUpdate);
    }
}
