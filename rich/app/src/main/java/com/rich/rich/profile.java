package com.rich.rich;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
    }

    public final void back_button_clicked (View view) {
        Intent intent_back_to_main = new Intent(this, MainActivity.class);
        startActivity(intent_back_to_main);

    }
}