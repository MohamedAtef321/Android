package com.rich.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class welcome2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView txtusrloged = (TextView) findViewById(R.id.your_user_id_welcome);
        // TextView txtpassloged = (TextView) findViewById(R.id.passloged);
        Bundle b1 = getIntent().getExtras();
        String username = b1.getString("username");
        // String password = b1.getString("password");
        String usrtxt = getResources().getString(R.string.userid);
        // String pswdtxt = getResources().getString(R.string.password);
        txtusrloged.setText(usrtxt+" "+username);
        // txtpassloged.setText(pswdtxt+" "+password);
    }
}