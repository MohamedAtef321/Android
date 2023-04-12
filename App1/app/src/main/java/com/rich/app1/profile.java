package com.rich.app1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        Bundle bundle_from_welcome = getIntent().getExtras();
        String sign_in_date_data = bundle_from_welcome.getString("sign_in_date");
        String user_id_data = bundle_from_welcome.getString("user_id");
        String user_name_data = bundle_from_welcome.getString("user_name");

        TextView sign_in_date_text = (TextView) findViewById(R.id.sign_in_date_data);
        TextView profile_name_text = (TextView) findViewById(R.id.profile_name);
        TextView user_name_text = (TextView) findViewById(R.id.username_data);
        TextView user_id_text = (TextView) findViewById(R.id.userid_data);

        profile_name_text.setText(getString(R.string.no_data));
        user_id_text.setText(getString(R.string.no_data));
        user_name_text.setText(getString(R.string.no_data));
        sign_in_date_text.setText(getString(R.string.no_data));

        if (sign_in_date_data != null
                & user_id_data != null
                & user_name_data != null) {
            profile_name_text.setText(user_name_data);
            user_id_text.setText(user_id_data);
            user_name_text.setText(user_name_data);
            sign_in_date_text.setText(sign_in_date_data);

        }

    }

    public final void back_button_clicked (View view) {
        Intent intent_back_to_main = new Intent(this, MainActivity.class);
        startActivity(intent_back_to_main);
        // Toast.makeText(this,"Username: "+etuser.getText().toString()+"\nPassword: "+etpswd.getText().toString(),Toast.LENGTH_LONG).show();

    }
}

