package com.rich.app1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


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
        // EditText etpswd = (EditText) findViewById(R.id.password);
        Bundle b1 = new Bundle();
        b1.putString("usernid",etuser.getText().toString());
        // b1.putString("password",etpswd.getText().toString());
        Intent intent_to_profile_id = new Intent(this, profile.class);
        intent_to_profile_id.putExtras(b1);
        startActivity(intent_to_profile_id);
        // Toast.makeText(this,"Username: "+etuser.getText().toString()+"\nPassword: "+etpswd.getText().toString(),Toast.LENGTH_LONG).show();

    }

    public final void sign_in_with_google_clicked (View view) {
        Intent intent_to_welcome = new Intent(this, welcome.class);
        startActivity(intent_to_welcome);
    }

    // private void hideSystemUI() {
    //     // Enables regular immersive mode.
    //     // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
    //     // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    //     View decorView = getWindow().getDecorView();
    //     decorView.setSystemUiVisibility(
    //             View.SYSTEM_UI_FLAG_IMMERSIVE
    //                     // Set the content to appear under the system bars so that the
    //                     // content doesn't resize when the system bars hide and show.
    //                     | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    //                     | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    //                     | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    //                     // Hide the nav bar and status bar
    //                     | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    //                     | View.SYSTEM_UI_FLAG_FULLSCREEN);
    // }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    //  private void showSystemUI() {
    //      View decorView = getWindow().getDecorView();
    //      decorView.setSystemUiVisibility(
    //              View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    //                      | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    //                      | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    //  }




}