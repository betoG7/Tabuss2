package com.tabus.tabuss;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tabus.tabuss.Rutas.Banquetes;
import com.tabus.tabuss.Rutas.BanquetesVerde;
import com.tabus.tabuss.Rutas.Juarez;
import com.tabus.tabuss.Rutas.Laureles;
import com.tabus.tabuss.Rutas.Lienzo;
import com.tabus.tabuss.Rutas.Potrerillos;
import com.tabus.tabuss.Rutas.RioGrande;
import com.tabus.tabuss.Rutas.VascoR;
import com.tabus.tabuss.Rutas.VascoV;


/**
 * Created by Humberto on 18/03/2015.
 */
public class Principio extends FragmentActivity {

    private static final String FAVS = "Favoritos";
    private static final String ALARM = "Alarma";
    public static double lat = 0.0;
    public static double longi = 0.0;
    LocationManager locationManager;
    EditText editText;

    public static double getLat() {
        return lat;
    }

    public static void setLat(double lat) {
        Principio.lat = lat;
    }

    public static double getLongi() {
        return longi;
    }

    public static void setLongi(double longi) {
        Principio.longi = longi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);


        locationManager=(LocationManager)getSystemService(LOCATION_SERVICE);

        //SI ESTA DESACTIVADO
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            /**Toast.makeText(this,"GPS desactivado",Toast.LENGTH_SHORT).show();

            Intent i=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(i);
            if(i==null)
            {
                System.exit(0);
            }**/
            AlertDialog.Builder alerBuilder=new AlertDialog.Builder(this);
            alerBuilder.setMessage("GPS desactivado.")
                    .setCancelable(false)
                    .setPositiveButton("Activar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            Intent GPSIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(GPSIntent);
                        }
                    });
            alerBuilder.setNegativeButton("Salir.", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                    System.exit(0);

                }
            });
            alerBuilder.create();
            alerBuilder.show();

        }
        else{

            if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                Toast.makeText(this, "GPS Desactivado, debes tenerlo activado",Toast.LENGTH_SHORT).show();
            }else {
                LocationGPS locationGPS = new LocationGPS();
                locationGPS.execute();
            }
        }



    }

    @Override
    protected void onRestart() {
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Intent GPSIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(GPSIntent);
            Toast.makeText(this, "GPS Desactivado, debes tenerlo activado",Toast.LENGTH_SHORT).show();
        }else {
            LocationGPS locationGPS = new LocationGPS();
            locationGPS.execute();
        }
        super.onRestart();

    }

    public void mapaVer(View v){
        Intent i=new Intent(this, MapsActivity.class);
        startActivity(i);

    }

    public void mapaBanquetes(View v){
        Intent i=new Intent(this,Banquetes.class);
        startActivity(i);
    }

    public void mapaLaureles(View v){
        Intent i=new Intent(this,Laureles.class);
        startActivity(i);
    }

    public void mapaPotre(View v){
        Intent i=new Intent(this,Potrerillos.class);
        startActivity(i);
    }

    public void mapaBanVerde(View v){
        Intent i=new Intent(this,BanquetesVerde.class);
        startActivity(i);
    }

    public void mapaRioG(View v){
        Intent i=new Intent(this, RioGrande.class);
        startActivity(i);
    }

    public void mapaVascoVerde(View v){
        Intent i=new Intent(this, VascoV.class);
        startActivity(i);
    }

    public void mapaVascoRojo(View v){
        Intent i=new Intent(this, VascoR.class);
        startActivity(i);
    }

    public void mapaLienzo(View v) {
        Intent i = new Intent(this, Lienzo.class);
        startActivity(i);
    }

    public void mapaJuarez(View v) {
        Intent i = new Intent(this, Juarez.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        //LocationListener locationListener=new LL();
        //locationManager.removeUpdates(locationListener);
        // Toast.makeText(this,"OnDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    public class LocationGPS extends AsyncTask<Void,Void,Void>{

        public LL ll;
        ProgressDialog progressDialog=null;

        @Override
        protected void onPreExecute() {
            ll=new LL();

            locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);


            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0,0, ll
            );
            //locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,ll);

            progressDialog = new ProgressDialog(Principio.this);
            progressDialog.setMessage("Obteniendo localizacion...");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);


            progressDialog.setCanceledOnTouchOutside(false);



            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();

           // editText=(EditText)findViewById(R.id.editText);
            //editText.setText("Lati: "+lat +" ,Long: "+longi);
        }

        @Override
        protected Void doInBackground(Void... params) {
            while(lat==0.0){

            }
            return null;
        }


    }

    public class LL implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {
            int lati=(int)location.getLatitude();
            int lon=(int)location.getLongitude();

            String infoloc=location.getProvider();
            try{
                lat=location.getLatitude();
                longi=location.getLongitude();
            }catch(Exception e){

            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }





}
