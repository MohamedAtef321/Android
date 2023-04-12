package com.anubix.tensecounds;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class input_data extends AppCompatActivity {

    public DatabaseReference database ;

    int user_id;
    String user_name, user_message;
    Bitmap user_photo;

    EditText user_name_text, user_message_text ;
    ImageView user_photo_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = FirebaseDatabase.getInstance().getReference("Database").child("Users");

        user_name_text = findViewById(R.id.user_name);
        user_message_text = findViewById(R.id.user_message);
        user_photo_image = findViewById(R.id.user_image);

        user_name = user_name_text.getText().toString();
        user_message = user_message_text.getText().toString();
        user_photo = ((BitmapDrawable) user_photo_image.getDrawable()).getBitmap();


        User user = new User(user_id, user_name, user_message, user_photo);


    }
}