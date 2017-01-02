package com.tabus.tabuss;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Humberto on 29/05/2015.
 */
public class veralarmas2 extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    ItemCompraAdapter adapter;
    int cont_alarm = 0;

    String arregloaño[];
    String arreglomeses[];
    String arregloañodia[];
    String arreglohor[];
    String arreglomin[];
    String arreglonumalar[];
    String resultados = "";
    int i = 0;
    ArrayList<ItemCompra> itemsCompra;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        consultanumalarmas();
        super.onCreate(savedInstanceState);


        setContentView(R.layout.main_list);


        if (cont_alarm != 0) {
            lv = (ListView) findViewById(R.id.listView);

            itemsCompra = obtenerItems();

            adapter = new ItemCompraAdapter(this, itemsCompra);

            lv.setAdapter(adapter);

            lv.setOnItemClickListener(this);

            //Toast.makeText(this, "" + cont_alarm, Toast.LENGTH_SHORT).show();
        }

    }

    public void consultanumalarmas() {
        cursoQL ch = new cursoQL(this, "BD", null, 1);
        SQLiteDatabase op = ch.getReadableDatabase();
        Cursor cursor = op.rawQuery("SELECT * FROM alarmas ORDER BY id DESC LIMIT 1", null);
        if (cursor.moveToFirst()) {
            do {
                resultados += "" + cursor.getString(0);

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
    }

    int cont1 = 0;
    ArrayList<ItemCompra> items = new ArrayList<ItemCompra>();

    cursoQL ch = new cursoQL(this, "BD", null, 1);

    private ArrayList<ItemCompra> obtenerItems() {

        SQLiteDatabase op = ch.getReadableDatabase();
        Cursor cursor = op.rawQuery("SELECT * FROM alarmas", null);
        if (cont1 == 0) {
            arregloaño = new String[cont_alarm];
            arreglomeses = new String[cont_alarm];
            arregloañodia = new String[cont_alarm];
            arreglohor = new String[cont_alarm];
            arreglomin = new String[cont_alarm];
            arreglonumalar = new String[cont_alarm];
            cont1++
            ;
        }
        if (cursor.moveToFirst()) {
            do {

                resultados = "";
                arregloaño[i] = cursor.getString(1);
                arreglomeses[i] = cursor.getString(2);
                arregloañodia[i] = cursor.getString(3);
                arreglohor[i] = cursor.getString(4);
                arreglomin[i] = cursor.getString(5);
                arreglonumalar[i] = cursor.getString(6);
                resultados += "hora" + cursor.getString(4);
                resultados += "minuto" + cursor.getString(5);
                i++;
                items.add(new ItemCompra(1, cursor.getString(7), resultados, "drawable/small_icon"));
                //   lista_items.add(new ArrayList(R.drawable.small_icon, "Juarez", resultados));
                // lista_items.add(new ArrayAdapter<String>(R.drawable.small_icon, "Juarez", resultados));

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        op.close();


        return items;
    }


    public void cancel() {

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar cal = new GregorianCalendar();
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        Calendar timeOff0 = Calendar.getInstance();
        timeOff0.set(Calendar.YEAR, año);
        timeOff0.set(Calendar.MONTH, meses - 1);
        timeOff0.set(Calendar.DAY_OF_MONTH, dia);
        timeOff0.set(Calendar.HOUR_OF_DAY, hor);
        timeOff0.set(Calendar.MINUTE, min);
        timeOff0.set(Calendar.SECOND, 0);
        intent.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, numalarm);
        alarmManager.cancel(pendingIntent);
        SQLiteDatabase op = ch.getReadableDatabase();
        resultados = "";
        op.execSQL("DELETE FROM alarmas WHERE numalarma='" + numalarm + "'");
        op.close();
        items.clear();
        itemsCompra.clear();
        metodo();


    }

    public void metodo() {
        SQLiteDatabase op = ch.getReadableDatabase();
        Cursor cursor = op.rawQuery("SELECT * FROM alarmas ORDER BY id DESC LIMIT 1", null);
        if (cursor.moveToFirst()) {
            do {
                resultados += "" + cursor.getString(0);

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
        lv = (ListView) findViewById(R.id.listView);

        ArrayList<ItemCompra> itemsCompra = obtenerItems();

        adapter = new ItemCompraAdapter(this, itemsCompra);

        lv.setAdapter(adapter);

    }

    int año = 0;
    int meses = 0;
    int dia = 0;
    int hor = 0;
    int min = 0;
    int numalarm = 0;
    int lvposi = 0;
    int cont = 1;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        año = 0;
        meses = 0;
        dia = 0;
        hor = 0;
        min = 0;
        numalarm = 0;
        //Intent intent1 = new Intent(this,alarma.class);
        if (cont == 1) {
            int año = Integer.parseInt(arregloaño[position]);
            int meses = Integer.parseInt(arreglomeses[position]);
            int dia = Integer.parseInt(arregloañodia[position]);
            int hor = Integer.parseInt(arreglohor[position]);
            int min = Integer.parseInt(arreglomin[position]);
            numalarm = Integer.parseInt(arreglonumalar[position]);
            lvposi = position;

        }
        Toast.makeText(this, "" + lvposi, Toast.LENGTH_SHORT).show();


        dialog.setMessage("¿Desea eliminar la alarma?");

        dialog.setCancelable(false);

        dialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                cancel();


            }


        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();


        // Toast.makeText(this,arregloaño[position], Toast.LENGTH_LONG).show();
    }
}






