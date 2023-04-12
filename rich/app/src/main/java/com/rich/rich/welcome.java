package com.rich.rich;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public final void submit_button_clicked (View view) {
        Intent intent_to_profile = new Intent(this, profile.class);
        startActivity(intent_to_profile);
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}