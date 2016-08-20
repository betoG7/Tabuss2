package com.tabus.tabuss;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;

/**
 * Created by Humberto on 02/06/2015.
 */
public class SMSReceiver extends BroadcastReceiver {

    public String a="";
    double lati;
    double longi;
    String llenado[];
    @Override
    public void onReceive(Context context, Intent intent) {
        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "";
        String numero="";
        if (bundle != null)
        {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            for (int i=0; i<msgs.length; i++){
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                str += "SMS from " + msgs[i].getOriginatingAddress();
                numero += "SMS from " + msgs[i].getOriginatingAddress();
                str += " :";
                str += msgs[i].getMessageBody().toString();
                a+= msgs[i].getMessageBody().toString();
                str += "\n";

            }
            cursoQL ch = new cursoQL(context, "BD", null, 1);
            SQLiteDatabase op = ch.getWritableDatabase();
            op.execSQL("INSERT INTO gpscamionz(id,a)  VALUES(null,'" + a + "')");
            op.close();
            //---display the new SMS message---
            //Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

        }
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    public double getLati() {
        return lati;
    }

    public void setLati(double lati) {
        this.lati = lati;
    }
}
