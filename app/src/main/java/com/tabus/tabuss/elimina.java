package com.tabus.tabuss;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Humberto on 29/05/2015.
 */
public class elimina extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    int position;
    String ruta;
    private Spinner s;
    private List<String> lista;
    String resultado;
    String resultados="";
    ArrayList<String> rutas;

    cursoQL chelpp=new cursoQL(this, "DB", null, 1);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        s= (Spinner)findViewById(R.id.Spinner);
        lista =new ArrayList<String>();
        s=(Spinner)this.findViewById(R.id.Spinner);

        mostrar();



        s.setOnItemSelectedListener(this);


    }



    public void mostrar (){

        lista =new ArrayList<String>();

        SQLiteDatabase op=chelpp.getReadableDatabase();
        Cursor cursor=op.rawQuery("SELECT * FROM favoritos group by ruta", null);

        if(cursor.moveToFirst()){
            do{
                resultados=cursor.getString(1);
                resultado+=cursor.getString(1);


                ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,lista);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                s.setAdapter(adapter);

                lista.add(resultados);
            }while(cursor.moveToNext());

        }







        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> view, View arg1,
                                       int texto, long arg3) {






            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // your code here
        //Salvar la posición y valor del item actual
        this.position = position;
        String selection = parent.getItemAtPosition(position).toString();

        //Mostramos la selección actual del Spinner
        // Toast.makeText(this,"Selección actual: "+selection,Toast.LENGTH_SHORT).show();

        ruta=selection;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "No se ha agregado rutas a favoritos aun ", Toast.LENGTH_SHORT).show();
    }

    public void borra(View v) {

        // adapter.notifyDataSetChanged();
        SQLiteDatabase db = chelpp.getReadableDatabase();


        String sql = "DELETE FROM favoritos where ruta='" + ruta + "'";
        db.execSQL(sql);


        Toast.makeText(getApplicationContext(), "Se ha borrado " + ruta + " de favoritos", Toast.LENGTH_SHORT).show();

    }
}
