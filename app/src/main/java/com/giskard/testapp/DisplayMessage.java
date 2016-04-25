package com.giskard.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessage extends AppCompatActivity {
    String msg = "DisplayMessage : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        String intentMessage = getResources().getString(R.string.debug_onCreate);
        Toast.makeText(DisplayMessage.this, msg + intentMessage, Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView (this);
        textView.setTextSize(40);
        textView.setText(message);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        String intentMessage = getResources().getString(R.string.debug_onStart);
        Toast.makeText(DisplayMessage.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        String intentMessage = getResources().getString(R.string.debug_onResume);
        Toast.makeText(DisplayMessage.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        String intentMessage = getResources().getString(R.string.debug_onPause);
        Toast.makeText(DisplayMessage.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        String intentMessage = getResources().getString(R.string.debug_onStop);
        Toast.makeText(DisplayMessage.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        String intentMessage = getResources().getString(R.string.debug_onDestroy);
        Toast.makeText(DisplayMessage.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }


}