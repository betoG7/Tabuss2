package com.tabus.tabuss;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


public class Alarma extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    Time time= new Time();
    private int mHour;
    private int mMinute;
    static final int TIME_DIALOG_ID = 0;
    //private TextView tvDateValue;//mTimeDisplay
    Button mPickTime;
    Button mDataTime;
    int año,comaño;
    int meses,conmes;
    int dia,comdia;
    int min;
    int hor;
    cursoQL ch = new cursoQL(this, "BD", null, 1);
    String resultados="";

    private Activity context;
    int cont_alarm;

    private Spinner s;
    private Spinner sp;
    private List<String> lista;
    String resultadoss;
    String resultados1="";
    ArrayList<String> rutas;
    String ruta;
    private int position;
    cursoQL chelpp=new cursoQL(this, "DB", null, 1);


    ArrayAdapter<CharSequence> adapterr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_agregar_alarma);
        //resultados+=0;
        //bd de numero de alarmas
        SQLiteDatabase op = ch.getReadableDatabase();
        Cursor cursor = op.rawQuery("SELECT * FROM numerodealarmas ORDER BY id DESC LIMIT 1", null);



        if(cursor.moveToFirst()){
            do{
                resultados+=""+cursor.getString(0);

            }
            while(cursor.moveToNext());

        }

        if(resultados==""){
            cont_alarm=0;

        }
        else {
            // resultados+=0;

            cont_alarm = Integer.parseInt(resultados);
        }

        cursor.close();
        op.close();



        // cursor.close();

       // Toast.makeText(this, "" + cont_alarm, Toast.LENGTH_SHORT).show();
        mPickTime =(Button)findViewById(R.id.pickTime);
        mDataTime =(Button)findViewById(R.id.btnCalendar);

        time.setToNow();
        min=time.minute;
        hor=time.hour;
        String botontiempo=""+hor+":"+min;
        mPickTime.setText(botontiempo);
        mPickTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });

        final Calendar c= Calendar.getInstance();
        mHour =c.get(Calendar.HOUR);
        mMinute =c.get(Calendar.MINUTE);
        año = c.get(Calendar.YEAR);
        comaño = c.get(Calendar.YEAR);
        conmes= c.get(Calendar.MONTH)+1;
        meses = c.get(Calendar.MONTH)+1;
        comdia= c.get(Calendar.DAY_OF_MONTH);
        dia= c.get(Calendar.DAY_OF_MONTH);
        String fecha=""+dia+"-"+meses+"-"+año;
        mDataTime.setText(fecha);
        updateDisaplay();


        //tvDateValue = (TextView) findViewById(R.id.dateValue);

        context = this;
        // Definición del botón calendar
        final Button btnOpenPopup = (Button) findViewById(R.id.btnCalendar);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener(){

            @Override
            /**
             * Al pulsar sobre el boton se abre la ventana modal con el componente DatePicker
             */
            public void onClick(View arg0) {
                showDatePickerDialog(arg0);
            }
        });

        s= (Spinner)findViewById(R.id.Spinner);
        lista =new ArrayList<String>();
        s=(Spinner)this.findViewById(R.id.Spinner);

        // datosSpinner();

        mostrar();



        s.setOnItemSelectedListener(this);

        SQLiteDatabase db = chelpp.getReadableDatabase();


        //  String sqll = "INSERT INTO favoritos(id,ruta) VALUES(null, '(selcciona ruta)')";
        //  db.execSQL(sqll);

       // adapterr = ArrayAdapter.createFromResource(this, R.array.lzo, android.R.layout.simple_spinner_item);
    }



    public void mostrar (){
        lista =new ArrayList<String>();

        SQLiteDatabase op=chelpp.getReadableDatabase();
        Cursor cursor=op.rawQuery("SELECT * FROM favoritos group by ruta", null);

        if(cursor.moveToFirst()){
            do{
                resultados1=cursor.getString(1);
                resultadoss+=cursor.getString(1);


                ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,lista);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                s.setAdapter(adapter);

                lista.add(resultados1);
            }while(cursor.moveToNext());

        }






        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> view, View arg1,
                                       int texto, long arg3) {



            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {



            }

        });

    }





    public void cons (View v){

        SQLiteDatabase op=chelpp.getReadableDatabase();
        Cursor cursor=op.rawQuery("SELECT * FROM favoritos", null);
        String resultados="";
        if(cursor.moveToFirst()){
            do{
                resultados=cursor.getString(0)+" "+cursor.getString(1);
                resultadoss+=cursor.getString(0)+" "+cursor.getString(1);
                rutas.add(""+resultados.toString());
            }while(cursor.moveToNext());

        }
        cursor.close();
        op.close();

       // Toast.makeText(getApplicationContext(),"" + resultados, Toast.LENGTH_SHORT).show();

    }
    protected void datosSpinner(){


        //  sp= (Spinner)findViewById(R.id.Spinner2);

        // sp=(Spinner)this.findViewById(R.id.Spinner2);



        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> view, View arg1,
                                       int texto, long arg3) {

                // sp= (Spinner)findViewById(R.id.Spinner2);



                if(ruta=="Lienzo charro") {


                    ArrayAdapter<CharSequence> adapters;

//Obtener instancia del GameSpinner
                    // Spinner spinner = (Spinner) findViewById(R.id.Spinner2);

//Asignas el origen de datos desde los recursos




//Asignas el layout a inflar para cada elemento
//al momento de desplegar la lista


//Seteas el adaptador
                    //  spinner.setAdapter(adapterr);
                    //  spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.textview_spinner, rutas));

                    s.setAdapter(adapterr);


                    adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    //  spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.textview_spinner, rutas));


                    s.setAdapter(adapterr);
                }

                //Toast.makeText(view.getContext(), view.getItemAtPosition(texto).toString(), Toast.LENGTH_SHORT).show();

            }



            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View selectedItemView, int position, long id) {
        this.position = position;
        String  selection = parent.getItemAtPosition(position).toString();

        //Mostramos la selección actual del Spinner
        //  Toast.makeText(this,"Selección actual: "+ruta,Toast.LENGTH_SHORT).show();

        ruta=selection;

        rut=selection;





    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"no se a agregado rutas a favoritos aun ",Toast.LENGTH_SHORT).show();
    }

    private void updateDisaplay(){
/*
    mTimeDisplay.setText((
            new StringBuilder()
            .append(pad(mHour)).append(":"))
            .append(pad(mMinute)));
    */
        min=mMinute;
        hor=mHour;
    }
    private static  String pad(int c){
        if(c>=10)
            return String.valueOf(c);
        else
            return "0"+String.valueOf(c);

    }
    TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener(){
                public void onTimeSet (TimePicker View, int hour0fDay, int minute){
                    mHour=hour0fDay;
                    mMinute=minute;
                    updateDisaplay();
                }};

    @Override
    protected Dialog onCreateDialog(int id){
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener, mHour, mMinute, false);
        }
        return null;
    }



    /**
     * Abre la ventana modal
     * @param v
     */
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(context.getFragmentManager(), "datePicker");
    }
    /**
     * Clase que se utiliza para abrir la ventana modal, extiende de DialogFragment.
     *
     */
    public class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Usar del defecto la fecha actual
            final Calendar c = Calendar.getInstance();
            // try {
            // Si en algun momento se ha informado la fecha se recupera
            String format = "MM-dd-yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
            //c.setTime(sdf.parse(String.valueOf(tvDateValue.getText())));
            // } catch (ParseException e) {
            // Si falla utilizaremos la fecha actual
            // }


            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of TimePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        /**
         * Recupera el valor seleccionado en el componente DatePicker e inserta el valor en el
         * y lo guardamos en la variable para enviarlo a la bd

         */


        public void onDateSet(DatePicker view, int year, int month, int day) {
            try{
                final Calendar c = Calendar.getInstance();
                c.set(year, month, day);
                String format = "MM-dd-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);


                año = c.get(Calendar.YEAR);
                meses = c.get(Calendar.MONTH)+1;
                dia= c.get(Calendar.DAY_OF_MONTH);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    String rut;
    String primeraruta="(seleciona ruta)";
    public void guarda(View v) {

        //     Toast.makeText(this, ""+rut, Toast.LENGTH_SHORT).show();
        if (rut.equalsIgnoreCase(primeraruta)) {

            Toast.makeText(this, "No ha seleccionado ruta", Toast.LENGTH_SHORT).show();
        } else {
          //  Toast.makeText(this, ""+primeraruta, Toast.LENGTH_SHORT).show();
            SQLiteDatabase op = ch.getWritableDatabase();
            op.execSQL("INSERT INTO alarmas(id,año,mes,dia,hora,min,numalarma,ruta)  VALUES(null,'" + año + "'," + "'" + meses + "'" + "," + "'" + dia + "'" + "," + "'" + hor + "'" + "," + "'" + min + "'" + "," + "'" + cont_alarm + "'" + "," + "'" + rut + "')");
            op.execSQL("INSERT INTO numerodealarmas(id,cont)  VALUES (NULL,'" + 1 + "')");
            op.close();
           Toast.makeText(this, "Se guardo", Toast.LENGTH_SHORT).show();


            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Calendar cal = new GregorianCalendar();
            Intent intent = new Intent(this, MyBroadcastReceiver.class);
            //Intent intent1 = new Intent(this,alarma.class);
            Calendar timeOff0 = Calendar.getInstance();

            timeOff0.set(Calendar.YEAR, año);
            timeOff0.set(Calendar.MONTH, meses - 1);
            timeOff0.set(Calendar.DAY_OF_MONTH, dia);
            timeOff0.set(Calendar.HOUR_OF_DAY, hor);
            timeOff0.set(Calendar.MINUTE, min);
            timeOff0.set(Calendar.SECOND, 0);
            intent.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    this.getApplicationContext(), 234324243, intent, cont_alarm);

            alarmManager.set(AlarmManager.RTC_WAKEUP, timeOff0.getTimeInMillis(), pendingIntent);
            cont_alarm++;
        }
        //  }

    }


}