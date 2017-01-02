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


public class Banquetes extends FragmentActivity {

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
    Timer timer;
    /*double lat = Principio.getLat();
    double longi = Principio.getLongi();*/
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private CameraUpdate cameraUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        //   timer=new Timer();
        String q = "";

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.cancelAll();

/**
 Timer timer = new Timer();
 timer.schedule(new TimerTask() {
@Override public void run() {

runOnUiThread(new Runnable() {
@Override public void run() {
//
resultados = "";
SQLiteDatabase op = ch.getReadableDatabase();
Cursor cursor = op.rawQuery("SELECT * FROM gpscamionz ORDER BY id DESC LIMIT 1", null);
if (cursor.moveToFirst()) {
do {
resultados += "" + cursor.getString(1);
//NEL resultado += "" + cursor.getString(2);
// NEL q=""+cursor.getString(3);
//  Toast.makeText(Banquetes.this,  resultados  , Toast.LENGTH_SHORT).show();
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


//       Toast.makeText(Banquetes.this, llenado[1] + " " + llenado[3] , Toast.LENGTH_SHORT).show();
//  String a = sm.a;
latitud = Double.parseDouble(llenado[1]);
longitud = Double.parseDouble(llenado[3]);


}
});

}
}, 0, 5000);

 **/
        mMap.clear();
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(20.351639, -102.059612)).width(10).color(Color.RED)
                .add(new LatLng(20.354873, -102.058217)).width(10).color(Color.RED)
                .add(new LatLng(20.355023, -102.058282)).width(10).color(Color.RED)
                .add(new LatLng(20.355526, -102.058142)).width(10).color(Color.RED)
                .add(new LatLng(20.355104, -102.056640)).width(10).color(Color.RED)
                .add(new LatLng(20.355858, -102.056307)).width(10).color(Color.RED)
                .add(new LatLng(20.356512, -102.055235)).width(10).color(Color.RED)
                .add(new LatLng(20.362054, -102.044892)).width(10).color(Color.RED)
                .add(new LatLng(20.362759, -102.043937)).width(10).color(Color.RED)
                .add(new LatLng(20.364137, -102.042843)).width(10).color(Color.RED)
                .add(new LatLng(20.362688, -102.044012)).width(10).color(Color.RED)
                .add(new LatLng(20.362266, -102.044484)).width(10).color(Color.RED)
                .add(new LatLng(20.359942, -102.048787)).width(10).color(Color.RED)
                .add(new LatLng(20.353313, -102.050020)).width(10).color(Color.RED)
                .add(new LatLng(20.348012, -102.030601)).width(10).color(Color.RED)
                .add(new LatLng(20.346614, -102.031116)).width(10).color(Color.RED)
                .add(new LatLng(20.343606, -102.032393)).width(10).color(Color.RED)
                .add(new LatLng(20.343325, -102.031234)).width(10).color(Color.RED)
                .add(new LatLng(20.343143, -102.030526)).width(10).color(Color.RED)
                .add(new LatLng(20.343164, -102.025720)).width(10).color(Color.RED)
                .add(new LatLng(20.343043, -102.025473)).width(10).color(Color.RED)
                .add(new LatLng(20.343073, -102.024067)).width(10).color(Color.RED)
                .add(new LatLng(20.341614, -102.024100)).width(10).color(Color.RED)
                .add(new LatLng(20.340870, -102.024024)).width(10).color(Color.RED)
                .add(new LatLng(20.340719, -102.023220)).width(10).color(Color.RED)
                .add(new LatLng(20.340568, -102.023177)).width(10).color(Color.RED)
                .add(new LatLng(20.339824, -102.021771)).width(10).color(Color.RED)
                .add(new LatLng(20.339844, -102.021643)).width(10).color(Color.RED)
                .add(new LatLng(20.338878, -102.020173)).width(10).color(Color.RED)
                .add(new LatLng(20.338848, -102.020044)).width(10).color(Color.RED)
                .add(new LatLng(20.337158, -102.018585)).width(10).color(Color.RED)
                .add(new LatLng(20.336615, -102.018349)).width(10).color(Color.RED)
                .add(new LatLng(20.336534, -102.018553)).width(10).color(Color.RED)
                .add(new LatLng(20.336031, -102.020677)).width(10).color(Color.RED)
                .add(new LatLng(20.334884, -102.020237)).width(10).color(Color.RED)
                .add(new LatLng(20.331464, -102.019014)).width(10).color(Color.RED)
                .add(new LatLng(20.330226, -102.018821)).width(10).color(Color.RED)
                .add(new LatLng(20.327709, -102.018821)).width(10).color(Color.RED)
                .add(new LatLng(20.327419, -102.019760)).width(10).color(Color.RED)
                .add(new LatLng(20.326564, -102.020672)).width(10).color(Color.RED)
                .add(new LatLng(20.325991, -102.022088)).width(10).color(Color.RED)
                .add(new LatLng(20.325699, -102.023257)).width(10).color(Color.RED)
                .add(new LatLng(20.325080, -102.023407)).width(10).color(Color.RED)
                .add(new LatLng(20.324406, -102.026851)).width(10).color(Color.RED)
                .add(new LatLng(20.323430, -102.028139)).width(10).color(Color.RED)
                .add(new LatLng(20.323128, -102.027870)).width(10).color(Color.RED)
                .add(new LatLng(20.324024, -102.026744)).width(10).color(Color.RED)
                .add(new LatLng(20.324316, -102.026991)).width(10).color(Color.RED)
                .add(new LatLng(20.324396, -102.026862)).width(10).color(Color.RED)
                .add(new LatLng(20.325070, -102.023407)).width(10).color(Color.RED)
                .add(new LatLng(20.324738, -102.023396)).width(10).color(Color.RED)
                .add(new LatLng(20.324778, -102.022828)).width(10).color(Color.RED)
                .add(new LatLng(20.324587, -102.021455)).width(10).color(Color.RED)
                .add(new LatLng(20.324688, -102.019716)).width(10).color(Color.RED)
                .add(new LatLng(20.324104, -102.018622)).width(10).color(Color.RED)
                .add(new LatLng(20.323803, -102.018579)).width(10).color(Color.RED)
                .add(new LatLng(20.323642, -102.018279)).width(10).color(Color.RED)
                .add(new LatLng(20.323953, -102.017249)).width(10).color(Color.RED)
                .add(new LatLng(20.324768, -102.017045)).width(10).color(Color.RED)
                .add(new LatLng(20.326177, -102.017410)).width(10).color(Color.RED)
                .add(new LatLng(20.327505, -102.017024)).width(10).color(Color.RED)
                .add(new LatLng(20.328622, -102.016777)).width(10).color(Color.RED)
                .add(new LatLng(20.329577, -102.016498)).width(10).color(Color.RED)
                .add(new LatLng(20.336444, -102.018311)).width(10).color(Color.RED)
                .add(new LatLng(20.337309, -102.017817)).width(10).color(Color.RED)
                .add(new LatLng(20.338335, -102.017581)).width(10).color(Color.RED)
                .add(new LatLng(20.339120, -102.017302)).width(10).color(Color.RED)
                .add(new LatLng(20.341816, -102.018311)).width(10).color(Color.RED)
                .add(new LatLng(20.342097, -102.019105)).width(10).color(Color.RED)
                .add(new LatLng(20.341715, -102.019877)).width(10).color(Color.RED)
                .add(new LatLng(20.343687, -102.023954)).width(10).color(Color.RED)
                .add(new LatLng(20.343807, -102.025242)).width(10).color(Color.RED)
                .add(new LatLng(20.346503, -102.025993)).width(10).color(Color.RED)
                .add(new LatLng(20.348234, -102.031250)).width(10).color(Color.RED)


        );


        //     mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud))
        //           .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp)));

        //Paradas();

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.351533, -102.059623))
                .title("Inicio de ruta")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start))
                .snippet("Ruta Roja"));


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


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.364104, -102.042852))
                .title("Parada oficial")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet("Tecnológico de La Piedad"));


        mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp)));

    }



                     /*   SQLiteDatabase op = ch.getReadableDatabase();
                        Cursor cursor = op.rawQuery("SELECT * FROM gpscamionz ORDER BY id DESC LIMIT 1", null);
                        if (cursor.moveToFirst()) {
                            do {
                                resultados += "" + cursor.getString(1);
                                //NEL resultado += "" + cursor.getString(2);
                                // NEL q=""+cursor.getString(3);
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
                       */

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
        //mMap.addMarker(new MarkerOptions().position(new LatLng(20.35474358, -102.05581295)).title("Marker"));

        cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(20.35474358, -102.05581295), 15);
        mMap.animateCamera(cameraUpdate);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // timer.cancel();
    }


}
