package com.giskard.testapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        String startMessage = getResources().getString(R.string.service_start);
        Toast.makeText(this, startMessage, Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        String stopMessage = getResources().getString(R.string.service_stop);
        super.onDestroy();
        Toast.makeText(this, stopMessage, Toast.LENGTH_LONG).show();
    }
}
