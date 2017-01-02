package com.tabus.tabuss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;


public class Principal_Main extends ActionBarActivity implements View.OnClickListener {


    private static final String FAVS = "Favoritos";
    private static final String ALARM = "Alarma";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal__main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.icon_small);

        FAB();
        // sendSMS("3521251968", "t020s015n123456");

    }


    private void FAB() {

        ImageView imageView = new ImageView(this); // Create an icon
        imageView.setImageResource(R.drawable.ic_add_white_24dp);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)

                .setContentView(imageView)
                .setBackgroundDrawable(R.drawable.selector_button)
                .build();


        // repeat many times:
        ImageView itemFAVS = new ImageView(this);
        itemFAVS.setImageResource(R.drawable.ic_grade_black_24dp);
        ImageView itemALARM = new ImageView(this);
        itemALARM.setImageResource(R.drawable.ic_alarm_add_black_24dp);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);

        //For Submenu
        SubActionButton buttonItemFAVS = itemBuilder.setContentView(itemFAVS).build();
        SubActionButton buttonItemALARM = itemBuilder.setContentView(itemALARM).build();


        buttonItemFAVS.setTag(FAVS);
        buttonItemALARM.setTag(ALARM);


        buttonItemFAVS.setOnClickListener(this);
        buttonItemALARM.setOnClickListener(this);


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttonItemFAVS)
                .addSubActionView(buttonItemALARM)
                // ...
                .attachTo(actionButton)
                .build();


    }

    @Override
    public void onClick(View v) {

        if (v.getTag().equals(FAVS)) {

            Intent i = new Intent(this, favoritos.class);
            startActivity(i);
        }
        if (v.getTag().equals(ALARM)) {
            Intent i = new Intent(this, Alarma.class);
            startActivity(i);
        }

    }

    public void Route(View v) {

        Intent i = new Intent(this, Principio.class);
        startActivity(i);
    }

 /*   public void Favor(View v) {

        Intent i = new Intent(this, favoritos.class);
        startActivity(i);
    }

    public void Alarmass(View v) {
        Intent i = new Intent(this, Alarma.class);
        startActivity(i);
    }*/


    /**
     * @Override protected void onDestroy() {
     * finish();
     * super.onDestroy();
     * }
     **/


   /* public void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);

    }*/


}
