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

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private CameraUpdate cameraUpdate;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

       /* NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.cancelAll();*/
        setUpMapIfNeeded();
       /* Timer timer = new Timer();
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


                        //  String a = sm.a;
                        //
                        latitud = Double.parseDouble(llenado[1]);
                        longitud = Double.parseDouble(llenado[3]);
//        Toast.makeText(this, resultados+" "+resultado+"::"+llenado[1]+":: "+llenado[3], Toast.LENGTH_SHORT).show();



                    }
                });

            }
        }, 0, 5000);
*/

        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(20.351519, -102.059616)).width(10).color(Color.RED)
                .add(new LatLng(20.354914, -102.058221)).width(10).color(Color.RED)
                .add(new LatLng(20.355095, -102.058275)).width(10).color(Color.RED)
                .add(new LatLng(20.355528, -102.058146)).width(10).color(Color.RED)
                .add(new LatLng(20.346615, -102.026067)).width(10).color(Color.RED)
                .add(new LatLng(20.343804, -102.025273)).width(10).color(Color.RED)
                .add(new LatLng(20.343623, -102.023900)).width(10).color(Color.RED)
                .add(new LatLng(20.341711, -102.020016)).width(10).color(Color.RED)
                .add(new LatLng(20.342093, -102.018921)).width(10).color(Color.RED)
                .add(new LatLng(20.341792, -102.018278)).width(10).color(Color.RED)
                .add(new LatLng(20.339136, -102.017334)).width(10).color(Color.RED)
                .add(new LatLng(20.337909, -102.017741)).width(10).color(Color.RED)
                .add(new LatLng(20.336873, -102.017891)).width(10).color(Color.RED)
                .add(new LatLng(20.336511, -102.018320)).width(10).color(Color.RED)
                .add(new LatLng(20.329629, -102.016539)).width(10).color(Color.RED)
                .add(new LatLng(20.328040, -102.016969)).width(10).color(Color.RED)
                .add(new LatLng(20.327074, -102.017140)).width(10).color(Color.RED)
                .add(new LatLng(20.325947, -102.017398)).width(10).color(Color.RED)
                .add(new LatLng(20.324720, -102.017011)).width(10).color(Color.RED)
                .add(new LatLng(20.323975, -102.017205)).width(10).color(Color.RED)
                .add(new LatLng(20.323653, -102.018535)).width(10).color(Color.RED)
                .add(new LatLng(20.318723, -102.018320)).width(10).color(Color.RED)
                .add(new LatLng(20.317597, -102.017419)).width(10).color(Color.RED)
                .add(new LatLng(20.316686, -102.016346)).width(10).color(Color.RED)
                .add(new LatLng(20.319370, -102.015832)).width(10).color(Color.RED)
                .add(new LatLng(20.316686, -102.016346)).width(10).color(Color.RED)
                .add(new LatLng(20.316107, -102.015681)).width(10).color(Color.RED)
                .add(new LatLng(20.315398, -102.016089)).width(10).color(Color.RED)
                .add(new LatLng(20.311504, -102.016647)).width(10).color(Color.RED)
                .add(new LatLng(20.311303, -102.015638)).width(10).color(Color.RED)
                .add(new LatLng(20.313114, -102.015381)).width(10).color(Color.RED)
                .add(new LatLng(20.313265, -102.016389)).width(10).color(Color.RED)


        );

        // latitud=0;
        //longitud=0;
       /* mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp)));
*/

        //Paradas();
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.351519, -102.059616))
                .title("Inicio Ruta")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start))
                .snippet("Delta"));
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
                .position(new LatLng(20.319387, -102.015827))
                .title("Parada oficial")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet("Hospital Gral. La Piedad"));


    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link com.google.android.gms.maps.SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(android.os.Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
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

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */


    /*double lat = pri.getLat();
    double longi = pri.getLongi();*/

    private void setUpMap() {

        //mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Marker"));20.349577, -102.036094
        cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(20.349577, -102.036094),15);
        //cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 15);
        mMap.animateCamera(cameraUpdate);
    }


}
