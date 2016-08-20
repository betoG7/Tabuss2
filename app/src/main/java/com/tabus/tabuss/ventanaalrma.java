package com.tabus.tabuss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Humberto on 29/05/2015.
 */
public class ventanaalrma extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity_alarma);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void agrealarma(View v){

        Intent i=new Intent(this, Alarma.class);
        startActivity(i);
    }
    public void veralarmas(View v){

        Intent i=new Intent(this, veralarmas2.class);
        startActivity(i);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
