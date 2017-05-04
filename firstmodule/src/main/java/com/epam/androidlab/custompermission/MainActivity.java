package com.epam.androidlab.custompermission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnSendClick(View view) {
       EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        EditText editTextSubject = (EditText) findViewById(R.id.editTextSubject);
        EditText editTextMessage = (EditText) findViewById(R.id.editTextMessage);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {editTextEmail.getText().toString()});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, editTextSubject.getText().toString());
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, editTextMessage.getText().toString());
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "Error finding E-mail application", Toast.LENGTH_SHORT).show();
        }
    }
}
