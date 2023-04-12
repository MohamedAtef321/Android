package com.rich.rich;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
    }

    public final void search_button_clicked (View view) {
        EditText etuser = (EditText) findViewById(R.id.your_user_id_welcome);
        Bundle b1 = new Bundle();
        b1.putString("username",etuser.getText().toString());
        Intent intent_to_profile_id = new Intent(this, profile.class);
        intent_to_profile_id.putExtras(b1);
        startActivity(intent_to_profile_id);

    }

    public final void sign_in_with_google_clicked (View view) {
        Intent intent_to_welcome = new Intent(this, welcome.class);
        startActivity(intent_to_welcome);
    }
}