package com.tabus.tabuss;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.tabus.tabuss.Rutas.Banquetes;
import com.tabus.tabuss.Rutas.BanquetesVerde;
import com.tabus.tabuss.Rutas.Laureles;
import com.tabus.tabuss.Rutas.Lienzo;
import com.tabus.tabuss.Rutas.Potrerillos;
import com.tabus.tabuss.Rutas.RioGrande;
import com.tabus.tabuss.Rutas.VascoR;
import com.tabus.tabuss.Rutas.VascoV;


public class MyBroadcastReceiver extends BroadcastReceiver {


    private final int NOTIFICATION_ID = 1010;

    String resultados = "";
    String ruta = "";
    int cont_alarm = 0;
    veralarmas2 v = new veralarmas2();

    @Override
    public void onReceive(Context context, Intent intent) {

  /*  cursoQL ch = new cursoQL(context, "BD", null, 1);
        SQLiteDatabase op = ch.getReadableDatabase();
        Cursor cursor = op.rawQuery("SELECT * FROM alarmas ORDER BY id DESC LIMIT 1", null);
        if (cursor.moveToFirst()) {
            do {
                resultados += "" + cursor.getString(0);
                Toast.makeText(context, ""+cursor.getString(0), Toast.LENGTH_SHORT).show();
            }
            while (cursor.moveToNext());

        }

        if (resultados == "") {
            cont_alarm = 0;

        } else {
            // resultados+=0;
            // Toast.makeText(this, ""+resultados, Toast.LENGTH_SHORT).show();
            cont_alarm = Integer.parseInt(resultados);
        }

        cursor.close();
        ch.close();
        nombre(context);*/
        cursoQL ch = new cursoQL(context, "BD", null, 1);
        SQLiteDatabase op = ch.getReadableDatabase();
        Cursor cursor = op.rawQuery("SELECT * FROM alarmas ORDER BY id  LIMIT 1", null);
        if (cursor.moveToFirst()) {
            do {
                resultados += "" + cursor.getString(0);
                ruta = "" + cursor.getString(7);
                //   Toast.makeText(context, ""+cursor.getString(0), Toast.LENGTH_SHORT).show();
            }
            while (cursor.moveToNext());

        }

        if (resultados == "") {
            cont_alarm = 0;

        } else {
            // resultados+=0;
            // Toast.makeText(this, ""+resultados, Toast.LENGTH_SHORT).show();
            cont_alarm = Integer.parseInt(resultados);
        }
        //op.execSQL("DELETE FROM alarmas WHERE numalarma='" + cont_alarm + "'");
        cursor.close();
        ch.close();

        // SQLiteDatabase op = ch.getReadableDatabase();
        // Cursor cursor = op.rawQuery("SELECT * FROM alarmas", null);
        //  Toast.makeText(context, ""+cont_alarm, Toast.LENGTH_SHORT).show();

        Notification.Builder builder = new Notification.Builder(context);
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.drawable.icon, "¡Alarma!", System.currentTimeMillis());
        //  NotificationCompat.Builder notificacion = new NotificationCompat.Builder(MainActivity.this);
        RemoteViews contentView = new RemoteViews(context.getPackageName(), R.layout.notification);
        contentView.setImageViewResource(R.id.img_notification, R.drawable.icon);
        contentView.setTextViewText(R.id.txt_notification, ruta);

        notification.contentView = contentView;
        Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notification.sound = defaultSound;
        builder.setSound(defaultSound);
        Intent notificationIntent = new Intent(context, Principal_Main.class);
        if (ruta.equalsIgnoreCase("Banquetes linea roja")) {
            notificationIntent = new Intent(context, Banquetes.class);
        }
        if (ruta.equalsIgnoreCase("Banquetes linea verde")) {
            notificationIntent = new Intent(context, BanquetesVerde.class);
        }
        if (ruta.equalsIgnoreCase("Vasco linea roja")) {
            notificationIntent = new Intent(context, VascoR.class);
        }
        if (ruta.equalsIgnoreCase("Vasco linea verde")) {
            notificationIntent = new Intent(context, VascoV.class);
        }
        if (ruta.equalsIgnoreCase("Lienzo charro")) {
            notificationIntent = new Intent(context, Lienzo.class);
        }
        if (ruta.equalsIgnoreCase("Potrerillos")) {
            notificationIntent = new Intent(context, Potrerillos.class);
        }
        if (ruta.equalsIgnoreCase("Laureles")) {
            notificationIntent = new Intent(context, Laureles.class);
        }
        if (ruta.equalsIgnoreCase("Delta")) {
            notificationIntent = new Intent(context, MapsActivity.class);
        }
        if (ruta.equalsIgnoreCase("Rio Grande")) {
            notificationIntent = new Intent(context, RioGrande.class);
        }


        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
        notification.contentIntent = contentIntent;

        notificationManager.notify(NOTIFICATION_ID, notification);


        v.vibrate(10000);
        borra(context);

    }

    public void borra(Context context) {
        cursoQL ch = new cursoQL(context, "BD", null, 1);
        SQLiteDatabase op = ch.getReadableDatabase();

        op.execSQL("DELETE FROM alarmas WHERE id='" + cont_alarm + "'");

        op.close();
        Toast.makeText(context, "entro" + cont_alarm, Toast.LENGTH_SHORT).show();
    }

 /*   String arregloaño [];
    String arreglomeses [];
    String arregloañodia [];
    String arreglohor [];
    String  arreglomin [];
    String arreglonumalar [];
    int i=0;
    public void nombre(Context context){
        cursoQL ch = new cursoQL(context, "BD", null, 1);
        SQLiteDatabase op = ch.getReadableDatabase();
        Cursor cursor = op.rawQuery("SELECT * FROM alarmas", null);

            arregloaño = new String[cont_alarm];
            arreglomeses = new String[cont_alarm];
            arregloañodia = new String[cont_alarm];
            arreglohor = new String[cont_alarm];
            arreglomin = new String[cont_alarm];
            arreglonumalar = new String[cont_alarm];

       // Toast.makeText(context, "entro", Toast.LENGTH_SHORT).show();
        if(cursor.moveToFirst()){
            do{

                resultados="";
                arregloaño[i]=cursor.getString(1);
                arreglomeses[i]=cursor.getString(2);
                arregloañodia[i]=cursor.getString(3);
                arreglohor[i]=cursor.getString(4);
                arreglomin[i]=cursor.getString(5);
                arreglonumalar[i]=cursor.getString(6);
                resultados+="hora"+cursor.getString(4);
                resultados+="minuto"+cursor.getString(5);
                i++;

                //   lista_items.add(new ArrayList(R.drawable.small_icon, "Juarez", resultados));
                // lista_items.add(new ArrayAdapter<String>(R.drawable.small_icon, "Juarez", resultados));

            }
            while(cursor.moveToNext());
        }

        cursor.close();
        op.close();


    }*/


}
