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


public class Juarez extends FragmentActivity {

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


}
});

}
}, 0, 5000);

 **/
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(20.372285, -102.032032)).width(10).color(Color.GREEN)
                .add(new LatLng(20.372224, -102.031120)).width(10).color(Color.GREEN)
                .add(new LatLng(20.368810, -102.031158)).width(10).color(Color.GREEN)
                .add(new LatLng(20.366941, -102.031340)).width(10).color(Color.GREEN)
                .add(new LatLng(20.363089, -102.031479)).width(10).color(Color.GREEN)
                .add(new LatLng(20.363428, -102.028928)).width(10).color(Color.GREEN)
                .add(new LatLng(20.361768, -102.028842)).width(10).color(Color.GREEN)
                .add(new LatLng(20.359636, -102.029099)).width(10).color(Color.GREEN)
                .add(new LatLng(20.359837, -102.030387)).width(10).color(Color.GREEN)
                .add(new LatLng(20.358343, -102.030580)).width(10).color(Color.GREEN)
                .add(new LatLng(20.358524, -102.031192)).width(10).color(Color.GREEN)
                .add(new LatLng(20.355788, -102.031535)).width(10).color(Color.GREEN)
                .add(new LatLng(20.355565, -102.030886)).width(10).color(Color.GREEN)
                .add(new LatLng(20.355590, -102.030822)).width(10).color(Color.GREEN)
                .add(new LatLng(20.355218, -102.029910)).width(10).color(Color.GREEN)
                .add(new LatLng(20.355097, -102.029523)).width(10).color(Color.GREEN)
                .add(new LatLng(20.355067, -102.029094)).width(10).color(Color.GREEN)
                .add(new LatLng(20.354700, -102.026026)).width(10).color(Color.GREEN)
                .add(new LatLng(20.353000, -102.026042)).width(10).color(Color.GREEN)
                .add(new LatLng(20.353140, -102.028182)).width(10).color(Color.GREEN)
                .add(new LatLng(20.353168, -102.029523)).width(10).color(Color.GREEN)
                .add(new LatLng(20.350754, -102.029727)).width(10).color(Color.GREEN)
                .add(new LatLng(20.350070, -102.029877)).width(10).color(Color.GREEN)
                .add(new LatLng(20.350050, -102.029083)).width(10).color(Color.GREEN)
                .add(new LatLng(20.349346, -102.028998)).width(10).color(Color.GREEN)
                .add(new LatLng(20.347736, -102.029491)).width(10).color(Color.GREEN)
                .add(new LatLng(20.346589, -102.026069)).width(10).color(Color.GREEN)
                .add(new LatLng(20.345825, -102.025758)).width(10).color(Color.GREEN)
                .add(new LatLng(20.345825, -102.025758)).width(10).color(Color.GREEN)
                .add(new LatLng(20.343682, -102.024760)).width(10).color(Color.GREEN)
                .add(new LatLng(20.343632, -102.024116)).width(10).color(Color.GREEN)
                .add(new LatLng(20.340845, -102.024052)).width(10).color(Color.GREEN)
                .add(new LatLng(20.340714, -102.023193)).width(10).color(Color.GREEN)
                .add(new LatLng(20.340594, -102.023172)).width(10).color(Color.GREEN)
                .add(new LatLng(20.339839, -102.021788)).width(10).color(Color.GREEN)
                .add(new LatLng(20.339819, -102.021616)).width(10).color(Color.GREEN)
                .add(new LatLng(20.338874, -102.020179)).width(10).color(Color.GREEN)
                .add(new LatLng(20.338813, -102.020039)).width(10).color(Color.GREEN)
                .add(new LatLng(20.337978, -102.019320)).width(10).color(Color.GREEN)
                .add(new LatLng(20.337153, -102.018580)).width(10).color(Color.GREEN)
                .add(new LatLng(20.336620, -102.018387)).width(10).color(Color.GREEN)
                .add(new LatLng(20.336537, -102.018467)).width(10).color(Color.GREEN)
                .add(new LatLng(20.336019, -102.020688)).width(10).color(Color.GREEN)
                .add(new LatLng(20.334530, -102.020130)).width(10).color(Color.GREEN)
                .add(new LatLng(20.334424, -102.020066)).width(10).color(Color.GREEN)
                .add(new LatLng(20.332744, -102.019444)).width(10).color(Color.GREEN)
                .add(new LatLng(20.332654, -102.019465)).width(10).color(Color.GREEN)
                .add(new LatLng(20.332211, -102.019277)).width(10).color(Color.GREEN)
                .add(new LatLng(20.330868, -102.018875)).width(10).color(Color.GREEN)
                .add(new LatLng(20.329797, -102.018794)).width(10).color(Color.GREEN)
                .add(new LatLng(20.330400, -102.020634)).width(10).color(Color.GREEN)
                .add(new LatLng(20.330571, -102.022324)).width(10).color(Color.GREEN)
                .add(new LatLng(20.330511, -102.022394)).width(10).color(Color.GREEN)
                .add(new LatLng(20.330189, -102.024390)).width(10).color(Color.GREEN)
                .add(new LatLng(20.332780, -102.024298)).width(10).color(Color.GREEN)
                .add(new LatLng(20.332810, -102.024223)).width(10).color(Color.GREEN)
                .add(new LatLng(20.333192, -102.024213)).width(10).color(Color.GREEN)
                .add(new LatLng(20.333348, -102.027565)).width(10).color(Color.GREEN)
                .add(new LatLng(20.334676, -102.027109)).width(10).color(Color.GREEN)
                .add(new LatLng(20.334948, -102.026755)).width(10).color(Color.GREEN)
                .add(new LatLng(20.335290, -102.026830)).width(10).color(Color.GREEN)
                .add(new LatLng(20.335833, -102.026557)).width(10).color(Color.GREEN)
                .add(new LatLng(20.336034, -102.026541)).width(10).color(Color.GREEN)
                .add(new LatLng(20.337075, -102.026085)).width(10).color(Color.GREEN)
                .add(new LatLng(20.337271, -102.024856)).width(10).color(Color.GREEN)
                .add(new LatLng(20.340596, -102.023215)).width(10).color(Color.GREEN)
                .add(new LatLng(20.342095, -102.023011)).width(10).color(Color.GREEN)
                .add(new LatLng(20.342402, -102.023161)).width(10).color(Color.GREEN)
                .add(new LatLng(20.343101, -102.023821)).width(10).color(Color.GREEN)
                .add(new LatLng(20.343654, -102.024127)).width(10).color(Color.GREEN)
                .add(new LatLng(20.343818, -102.025296)).width(10).color(Color.GREEN)
                .add(new LatLng(20.345392, -102.025661)).width(10).color(Color.GREEN)
                .add(new LatLng(20.346504, -102.026015)).width(10).color(Color.GREEN)
                .add(new LatLng(20.346846, -102.026476)).width(10).color(Color.GREEN)
                .add(new LatLng(20.347392, -102.028349)).width(10).color(Color.GREEN)
                .add(new LatLng(20.350103, -102.028016)).width(10).color(Color.GREEN)
                .add(new LatLng(20.350052, -102.029883)).width(10).color(Color.GREEN)
                .add(new LatLng(20.350753, -102.029700)).width(10).color(Color.GREEN)
                .add(new LatLng(20.353142, -102.029523)).width(10).color(Color.GREEN)
                .add(new LatLng(20.352956, -102.028627)).width(10).color(Color.GREEN)
                .add(new LatLng(20.352730, -102.026047)).width(10).color(Color.GREEN)
                .add(new LatLng(20.353987, -102.026047)).width(10).color(Color.GREEN)
                .add(new LatLng(20.354254, -102.028466)).width(10).color(Color.GREEN)
                .add(new LatLng(20.354596, -102.032345)).width(10).color(Color.GREEN)
                .add(new LatLng(20.355310, -102.032232)).width(10).color(Color.GREEN)
                .add(new LatLng(20.356019, -102.032152)).width(10).color(Color.GREEN)
                .add(new LatLng(20.356789, -102.032076)).width(10).color(Color.GREEN)
                .add(new LatLng(20.355931, -102.029426)).width(10).color(Color.GREEN)
                .add(new LatLng(20.357269, -102.029319)).width(10).color(Color.GREEN)
                .add(new LatLng(20.358637, -102.029158)).width(10).color(Color.GREEN)
                .add(new LatLng(20.359190, -102.029105)).width(10).color(Color.GREEN)
                .add(new LatLng(20.359590, -102.029041)).width(10).color(Color.GREEN)
                .add(new LatLng(20.359675, -102.029084)).width(10).color(Color.GREEN)
                .add(new LatLng(20.362145, -102.028864)).width(10).color(Color.GREEN)
                .add(new LatLng(20.363422, -102.028907)).width(10).color(Color.GREEN)
                .add(new LatLng(20.363090, -102.031476)).width(10).color(Color.GREEN)


        );


        mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp)));


        //Paradas();
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.372285, -102.032032))
                .title("Inicio Ruta")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start))
                .snippet("Juarez"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.359610, -102.029097))
                .title("Parada")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet(""));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.355813, -102.031553))
                .title("Parada")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet(""));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.354044, -102.026062))
                .title("Parada")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet(""));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.353063, -102.026084))
                .title("Parada")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet("Soriana"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.350061, -102.029882))
                .title("Parada")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet(""));
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
                .position(new LatLng(20.340204, -102.022465))
                .title("Parada oficial")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet("Farmacia Similares"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.329815, -102.018863))
                .title("Parada ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet("El Campestre"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.333200, -102.024201))
                .title("Parada")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet(""));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.340850, -102.023163))
                .title("Parada")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet("Señor de La Piedad"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.342514, -102.023239))
                .title("Parada oficial")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop))
                .snippet("Aquiles Serdan"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.348256, -102.028246))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.norte)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.349654, -102.028080))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.norte)));


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
        cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(20.349577, -102.036094), 15);
        //cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 15);
        mMap.animateCamera(cameraUpdate);
    }
}
