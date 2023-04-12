package com.anubix.tensecounds;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.hide();




    }

    public final void sign_up_button_clicked (View view) {
        Intent to_input_data = new Intent(this, input_data.class);
        startActivity(to_input_data);
    }
}