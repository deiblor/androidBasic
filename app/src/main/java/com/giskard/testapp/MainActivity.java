package com.giskard.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.giskard.testapp.MESSAGE";
    String msg = "MyActivity : ";
    TextView myTextView;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.edit_message);
        //myTextView.setOnClickListener(sendClickListener);

        String intentMessage = getResources().getString(R.string.debug_onCreate);
        Toast.makeText(MainActivity.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        String intentMessage = getResources().getString(R.string.debug_onStart);
        Toast.makeText(MainActivity.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        String intentMessage = getResources().getString(R.string.debug_onResume);
        Toast.makeText(MainActivity.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        String intentMessage = getResources().getString(R.string.debug_onPause);
        Toast.makeText(MainActivity.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        String intentMessage = getResources().getString(R.string.debug_onStop);
        Toast.makeText(MainActivity.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        String intentMessage = getResources().getString(R.string.debug_onDestroy);
        Toast.makeText(MainActivity.this, msg + intentMessage, Toast.LENGTH_SHORT).show();
    }

    /**Called when the user clicks the send button **/
    public void sendMessage(View view){
        //Do something in response to button
        Intent intent = new Intent (this, DisplayMessage.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

        myTextView.setText("");
    }

    /**
     * Click Handler - This will clear the textview whenever someone clicks it.
     */
    /**private View.OnClickListener sendClickListener= new View.OnClickListener() {
        public void onClick(View v) {
            myTextView.setText("");
        }
    };
    **/

    /** Method to start the service **/
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    /** Method to stop the service **/
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    /** Broadcast a custom intent **/
    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.giskard.testapp.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    /** Open the database view  **/
    public void startDatabase(View view){
        //Do something in response to button
        Intent intent = new Intent (this, DisplayDatabase.class);
        startActivity(intent);
    }
}
