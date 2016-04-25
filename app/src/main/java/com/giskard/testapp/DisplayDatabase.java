package com.giskard.testapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayDatabase extends AppCompatActivity {
    TextView studentTextView;
    TextView gradeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_database);

        studentTextView = (TextView) findViewById(R.id.edit_student);
        gradeTextView = (TextView) findViewById(R.id.edit_grade);
    }

    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();

        values.put(StudentsProvider.NAME,
                ((EditText)findViewById(R.id.edit_student)).getText().toString());

        values.put(StudentsProvider.GRADE,
                ((EditText)findViewById(R.id.edit_grade)).getText().toString());

        Uri uri = getContentResolver().insert(
                StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();

        // Clear the textView fields after the information is added to database
        studentTextView.setText("");
        gradeTextView.setText("");
    }

    public void onClickRetrieveStudents(View view) {

        // Retrieve student records
        String URL = "content://com.giskard.testapp.college/students";

        Uri students = Uri.parse(URL);
        //Cursor c = managedQuery(students, null, null, null, "name");
        Cursor c = getContentResolver().query(students, null, null, null, "_ID");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                                ", " +  c.getString(c.getColumnIndex( StudentsProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentsProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
            c.close();
        }
    }
}
