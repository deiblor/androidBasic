package com.giskard.testapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String intentMessage = context.getResources().getString(R.string.intent_received);
        Toast.makeText(context, intentMessage, Toast.LENGTH_LONG).show();
    }
}
