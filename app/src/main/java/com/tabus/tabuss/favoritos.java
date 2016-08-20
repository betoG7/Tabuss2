package com.tabus.tabuss;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Humberto on 29/05/2015.
 */
public class favoritos extends ActionBarActivity implements AdapterView.OnItemSelectedListener{
    String sqll;
    String resultado="";
    ArrayList<String> rutas;
    ArrayAdapter<String> adapter;
    ListView lstView;
    String ruta;
    cursoQL chelpp=new cursoQL(this, "DB", null, 1);


    private Spinner s;
    private List<String> lista;
    private int position;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favs);

        datosSpinner();

        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item,rutas);


        s= (Spinner)findViewById(R.id.Spinner);
        lista =new ArrayList<String>();
        s=(Spinner)this.findViewById(R.id.Spinner);

        s.setOnItemSelectedListener(this);



        //  s.setAdapter(new ArrayAdapter<String>(this, R.layout.textview_spinner, rutas));
        SQLiteDatabase db = chelpp.getReadableDatabase();


        String sqll = "INSERT INTO favoritos(id,ruta) VALUES(null, '(seleciona ruta)')";
        db.execSQL(sqll);
    }


    public void agregar(View v) {

        SQLiteDatabase db = chelpp.getReadableDatabase();


        String sql = "INSERT INTO favoritos(id,ruta) VALUES(null, '" + ruta + "')";
        db.execSQL(sql);


        Toast.makeText(getApplicationContext(), "se a agregado " + ruta + " a favoritos", Toast.LENGTH_SHORT).show();


        //
    }
    public void cambio(View v) {

        Intent intentala = new Intent(favoritos.this, elimina.class);
        startActivity(intentala);


    }

    public void alarma(View v) {

        Intent intentala = new Intent(favoritos.this, ventanaalrma.class);
        startActivity(intentala);


    }

    public void borrar(View v) {


        SQLiteDatabase db = chelpp.getReadableDatabase();


        String sql = "DELETE FROM favoritos where ruta='" + ruta + "'";
        db.execSQL(sql);


        Toast.makeText(getApplicationContext(), "Se ha borrado " + ruta + " de favoritos", Toast.LENGTH_SHORT).show();

    }





    protected void datosSpinner(){


        s= (Spinner)findViewById(R.id.Spinner);
        lista =new ArrayList<String>();
        s=(Spinner)this.findViewById(R.id.Spinner);


        ArrayAdapter<CharSequence> adapter;

        ArrayAdapter<CharSequence> adapters;

//Obtener instancia del GameSpinner
        Spinner spinner = (Spinner) findViewById(R.id.Spinner);

//Asignas el origen de datos desde los recursos
        adapter = ArrayAdapter.createFromResource(this, R.array.rutas, android.R.layout.simple_spinner_item);


//Seteas el adaptador
        spinner.setAdapter(adapter);
        //  spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.textview_spinner, rutas));

        s.setAdapter(adapter);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //  spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.textview_spinner, rutas));


        s.setAdapter(adapter);


        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> view, View arg1,
                                       int texto, long arg3) {

                //Toast.makeText(view.getContext(), view.getItemAtPosition(texto).toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.position = position;
        String  selection = parent.getItemAtPosition(position).toString();

        //Mostramos la selección actual del Spinner
        //  Toast.makeText(this,"Selección actual: "+selection,Toast.LENGTH_SHORT).show();

        ruta=selection;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
