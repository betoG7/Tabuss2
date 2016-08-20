package com.tabus.tabuss;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Humberto on 29/05/2015.
 */
public class TestService extends Service {

    public TestService(){

    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
