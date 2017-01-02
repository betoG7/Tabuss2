package com.tabus.tabuss.Rutas;

import android.app.NotificationManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
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
 * Created by Humberto on 25/04/2015.
 */
public class Potrerillos extends FragmentActivity {


    Principio p = new Principio();
    SMSReceiver smsre = new SMSReceiver();
    double lt = smsre.getLati();
    double ln = smsre.getLongi();
    double latitud, longitud;
    cursoQL ch = new cursoQL(this, "BD", null, 1);
    String resultados = "";
    String resultado = "";
    String llenado[];
    int vari;
    /*double lat = Principio.getLat();
    double longi = Principio.getLongi();*/
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private CameraUpdate cameraUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.cancelAll();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //

                        resultados = "";
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
                        vari = resultados.length();
                        llenado = new String[vari];
                        int a = 0;
                        StringTokenizer tokens = new StringTokenizer(resultados, ": ");
                        while (tokens.hasMoreTokens()) {
                            if (a < vari) {
                                llenado[a] = tokens.nextToken();
                                a++;
                            }
                        }


                        //       Toast.makeText(this, resultados + " " + resultado + "" + q, Toast.LENGTH_SHORT).show();
                        //  String a = sm.a;
                        latitud = Double.parseDouble(llenado[1]);
                        longitud = Double.parseDouble(llenado[3]);


                        mMap.addPolyline(new PolylineOptions().geodesic(true)
                                .add(new LatLng(20.343668, -102.024281)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.343597, -102.023851)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.342984, -102.022789)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.342506, -102.023197)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.343658, -102.024162)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.343809, -102.025305)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.345549, -102.025691)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.346696, -102.026099)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.349602, -102.026104)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.353123, -102.026050)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.355970, -102.025953)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.358987, -102.025964)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.369081, -102.025739)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.376076, -102.025599)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.375995, -102.023425)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.374598, -102.023503)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.374648, -102.021878)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.374734, -102.020065)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.376715, -102.019888)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.376388, -102.023053)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.377409, -102.023063)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.377464, -102.025585)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.376076, -102.025599)).width(10).color(Color.GREEN)


                        );

                        //Paradas();


                        mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud))
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp)));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.344163, -102.025596))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("La Purisima"));


                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.346601, -102.025981))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet(""));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.350972, -102.025971))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet(""));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.353146, -102.026032))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Soriana"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.356099, -102.025954))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Las Tres Huastecas"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.362101, -102.025885))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Cancha Futbol Siete"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.366661, -102.025835))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Arroyo Hondo"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.372693, -102.025686))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Taxis Cd. del Sol"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.375976, -102.025596))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Mercado Cd. del Sol"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.342514, -102.023239))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start))
                                .snippet("Aquiles Serdan"));


                    }
                });

            }
        }, 0, 5000);


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
        cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(20.349577, -102.036094),15);
        //cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 15);
        mMap.animateCamera(cameraUpdate);
    }
}

