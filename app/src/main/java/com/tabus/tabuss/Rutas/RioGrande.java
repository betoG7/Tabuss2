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
 * Created by Humberto on 02/05/2015.
 */
public class RioGrande extends FragmentActivity {

    LocationManager locationManager;
    Principio pri = new Principio();
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


                        //   Toast.makeText(this, resultados + " " + resultado + "" + q, Toast.LENGTH_SHORT).show();
                        //  String a = sm.a;
                        latitud = Double.parseDouble(llenado[1]);
                        longitud = Double.parseDouble(llenado[3]);


                        mMap.addPolyline(new PolylineOptions().geodesic(true)
                                .add(new LatLng(20.351720, -102.058189)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.351008, -102.057062)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.351894, -102.056689)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.354110, -102.053106)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.346641, -102.026134)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.343900, -102.025329)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.343638, -102.024127)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.341722, -102.020104)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.342044, -102.019031)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.341802, -102.018301)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.339046, -102.017314)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.337331, -102.017829)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.336516, -102.018312)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.329635, -102.016531)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.328598, -102.016810)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.326596, -102.017325)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.325258, -102.017229)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.324463, -102.017025)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.324141, -102.016778)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.324302, -102.012336)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.323689, -102.007079)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.322786, -102.005754)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.322569, -102.005604)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.320904, -102.002675)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.323485, -102.002391)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.323173, -101.999880)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.325643, -101.998893)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.334013, -101.998324)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.334139, -102.002439)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.335216, -102.002294)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.335683, -102.001623)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.335693, -102.000476)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.336926, -102.000459)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.337062, -102.001044)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.343783, -102.000742)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.343813, -102.005368)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.344108, -102.005416)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.343938, -102.006895)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.345285, -102.007054)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.345841, -102.003523)).width(10).color(Color.GREEN)
                                .add(new LatLng(20.343855, -102.003388)).width(10).color(Color.GREEN)

                        );


                        mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud))
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp)));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.351720, -102.058189))
                                .title("Inicio de Ruta")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start))
                                .snippet("Rio Grande"));

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
                                .position(new LatLng(20.343475, -102.023776))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Parada Cajeta Cabadas"));


                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.341794, -102.020209))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Los Puentes"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.341696, -102.019669))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Los Puentes"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.336694, -102.018191))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("La Glorieta"));


                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.332799, -102.017393))
                                .title("Parada oficial")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Lic. Rafael Reyes"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.323467, -102.002394))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Iglesia Cuitzillo"));

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(20.327451, -101.998875))
                                .title("Parada")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                                .snippet("Fracc. Cuitzillo"));


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
        //cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(20.349577, -102.036094),15);
        cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(20.349577, -102.036094),15);
//        cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 15);
        mMap.animateCamera(cameraUpdate);
    }


}
