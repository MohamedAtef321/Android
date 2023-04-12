package com.rich.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.karumi.dexter.Dexter;
import com.nostra13.universalimageloader.*;
// import ImagePicker from 'react-native-image-crop-picker';

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;


public class welcome extends AppCompatActivity {

    private static final int RESULT_LOAD_IMG = 1;
    String selected_image_path = "" ;
    final int PICK_IMAGE = 1;



    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView txtusrloged = (TextView) findViewById(R.id.your_user_id_welcome);
        // TextView txtpassloged = (TextView) findViewById(R.id.passloged);
        //  Bundle b1 = getIntent().getExtras();
        //  String username = b1.getString("userid");
        // String password = b1.getString("password");
        String usrtxt = getResources().getString(R.string.userid);
        // String pswdtxt = getResources().getString(R.string.password);
        //  txtusrloged.setText(usrtxt+" "+username);
        // txtpassloged.setText(pswdtxt+" "+password);

        // ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        // ImageView testimage = (ImageView) findViewById(R.id.testimage);
        // Resources r = getResources();
        // Drawable[] layers = new Drawable[2];
        // layers[0] = r.getDrawable(R.drawable.rich_user_card);
        // layers[1] = r.getDrawable(R.drawable.rich_logo);
        // LayerDrawable layerDrawable = new LayerDrawable(layers);
        // testimage.setImageDrawable(layerDrawable);

        // DatePicker sign_in_date = (DatePicker) view.

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH) + 1;
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        // final int date = calendar.get(Calendar.DATE);
        TextView sign_in_date = (TextView) findViewById(R.id.sign_in_date_data_welcome);
        String sign_in_date_data = year+"-"+month+"-"+day;
        sign_in_date.setText(sign_in_date_data);



        // TextView sign_in_date22 = (TextView) findViewById(R.id.sign_in_date_data_welcome);
        // sign_in_date22.setText(date);




    }

    // public void onActivityResult ( int requestCode,int resultCode , Intent data ) {
    //     if (resultCode == RESULT_OK) {
    //         if (requestCode == PICK_IMAGE) {
    //             Uri selected_image_uri = data.getData();
    //             selected_image_path = getDatabasePath(selected_image_uri);
    //         }
    //     }
    // }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        ImageView image_view = findViewById(R.id.example_card);


        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);


                //  image_view.setImageBitmap(selectedImage);

                // Get your images from their files
                //  Bitmap bottomImage = BitmapFactory.decodeFile("myFirstPNG.png");

                image_view.setImageResource(R.drawable.rich_user_card);
                Bitmap topImage = ((BitmapDrawable) image_view.getDrawable()).getBitmap();


                // As described by Steve Pomeroy in a previous comment,
                // use the canvas to combine them.
                // Start with the first in the constructor..
                // try {
                //     Canvas comboImage = new Canvas (selectedImage);
                //     // Then draw the second on top of that
                //     comboImage.drawBitmap(topImage, 0f, 0f, null);
                //
                //     image_view.setImageBitmap(selectedImage);
                // }
                // catch (Exception e){
                //     e.printStackTrace();
                //     Toast.makeText((this), "", Toast.LENGTH_SHORT).show();
                // }


                // comboImage is now a composite of the two.

                // // To write the file out to the SDCard:
                // OutputStream os = null;
                // try {
                //     os = new FileOutputStream("/sdcard/DCIM/Camera/" + "myNewFileName.png");
                //     comboImage.compress(CompressFormat.PNG, 50, os)
                // } catch(IOException e) {
                //     e.printStackTrace();
                // }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }



    }

    public final void example_card_clicked (View view) {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        photoPickerIntent.putExtra("crop","true");
        photoPickerIntent.putExtra("aspectX",1);
        photoPickerIntent.putExtra("aspectY",1);
        photoPickerIntent.putExtra("outputX",200);
        photoPickerIntent.putExtra("outputY",200);
        photoPickerIntent.putExtra("return-data",true);
        //  Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        //  photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);


        // Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        // getIntent.setType("image/*");
        //
        // Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // pickIntent.setType("image/*");
        //
        // Intent chooserIntent = Intent.createChooser(getIntent,"Select your Photo");
        // chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
        //
        // startActivityForResult(chooserIntent, PICK_IMAGE);



        // Bitmap img = getIntent.getAction();
        // Bitmap img = (Bitmap) chooserIntent.getExtras().get(Intent.EXTRA_INITIAL_INTENTS);
        // ImageView imgex = findViewById(R.id.example_card);
        // imgex.setImageBitmap(img);

        // Intent intent = new Intent();
        // intent.setType("image/*");
        // intent.setAction(Intent.ACTION_GET_CONTENT);
        // startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);

        // ImageView test_image = (ImageView) findViewById(R.id.testimage);
        // File file = null;
        // ImagePicker.Companion.with(this).galleryOnly().saveDir(new File(Environment.getExternalStorageDirectory(), "ImagePicker"));
        // String file_path = file.getPath();
        // Bitmap image = BitmapFactory.decodeFile(file_path);
        // test_image.setImageBitmap(image);

        // ImagePicker.EXTRA_IMAGE_PROVIDER.

        // ImagePicker.Companion.with(this)
        //         .galleryOnly()	//User can only select image from Gallery
        //         .start();	//Default Request Code is ImagePicker.REQUEST_CODE
        //
        // ImagePicker.Companion.with(this)
        //         .crop(1f, 1f)	//Crop image with 1:1 aspect ratio
        //         .start();
        //
        // ImagePicker.Companion.with(this)
        //         //Provide directory path to save images
        //         .saveDir(new File(Environment.getExternalStorageDirectory(), "ImagePicker"))
        //         // .saveDir(Environment.getExternalStorageDirectory())
        //         // .saveDir(getExternalFilesDir(null)!!)
        //         .start();

        // final String TAG = "JoinImage";
        // Bitmap mBackImage, mTopImage, mBackground;
        // BitmapDrawable mBitmapDrawable;
        // String mTempDir;
        // String mSavedImageName = null;
        // FileOutputStream mFileOutputStream = null;
        // Canvas mCanvas;
        //
        // //Create folder in SDCard to store newly generated image
        // mTempDir = Environment.getExternalStorageDirectory() + "/TestTemp/";
        // File mTempFile = new File(mTempDir);
        // if(!mTempFile.exists()) {
        //     mTempFile.mkdirs();
        // }
        // //File name
        // mSavedImageName = "Test.png";
        // //Width = 604, Height = 1024 Change as per your requirement
        // mBackground = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        // //Put back and top images in your res folder
        // mBackImage = BitmapFactory.decodeResource(getResources(), R.drawable.rich_logo);
        // mTopImage = BitmapFactory.decodeResource(getResources(), R.drawable.rich_user_card);
        //
        // mCanvas = new Canvas(mBackground);
        // mCanvas.drawBitmap(mBackImage, 0f, 0f, null);
        // mCanvas.drawBitmap(mTopImage, 12f, 12f, null);
        //
        // try {
        //     mBitmapDrawable = new BitmapDrawable(Bitmap.createBitmap().getResources(),mBackground);
        //     Bitmap mNewSaving = mBitmapDrawable.getBitmap();
        //     String FtoSave = mTempDir + mSavedImageName;
        //     File mFile = new File(FtoSave);
        //     mFileOutputStream = new FileOutputStream(mFile);
        //     mNewSaving.compress(CompressFormat.PNG, 95, mFileOutputStream);
        //     mFileOutputStream.flush();
        //     mFileOutputStream.close();
        // } catch(FileNotFoundException e) {
        //     Log.e(TAG, "FileNotFoundExceptionError " + e.toString());
        // } catch(IOException e) {
        //     Log.e(TAG, "IOExceptionError " + e.toString());
        // }
        // Log.i(TAG, "Image Created");
    }

    public final void load_button_clicked (View view) {

        TextView signindate = findViewById(R.id.sign_in_date_data_welcome);
        TextView userid = findViewById(R.id.user_id_data_welcome);
        TextView username = findViewById(R.id.user_name_welcome);

        String signindate_text = "" , userid_text = "" , username_text = "" ;

        try {
            FileInputStream input_file = this.openFileInput("rich_data.txt");
            int data_char_num = 0 , data_step = 1;
            while ((data_char_num = input_file.read()) != -1) {
                String ch = String.valueOf((char) data_char_num) ;
                while (data_step >= 3) {
                    if (ch == ":") {
                        data_step += 1;
                    } else if (data_step == 1) {
                        userid_text += ch;
                    } else if (data_step == 2) {
                        username_text += ch;
                    } else if (data_step == 3) {
                        signindate_text += ch;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG);
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG);
            e.printStackTrace();
        }

        signindate.setText(signindate_text);
        userid.setText(userid_text);
        username.setText(username_text);

    }

    public final void submit_button_clicked (View view) {

        TextView signindate = findViewById(R.id.sign_in_date_data_welcome);
        TextView userid = findViewById(R.id.user_id_data_welcome);
        TextView username = findViewById(R.id.user_name_welcome);

        final String output_file_name = "rich_data.txt";
        FileOutputStream output_file = null;

        try {
            output_file = openFileOutput(output_file_name,this.MODE_PRIVATE);
            String data = userid.getText().toString()
                    + ":" + username.getText().toString()
                    + ":" + signindate.getText().toString() ;
            byte data_bytes[] = data.getBytes();
            output_file.write(data_bytes);
            Toast.makeText(this,"Data saved to "+getFilesDir()+"/"+output_file_name,Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if (output_file != null) {
                try {
                    output_file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        Bundle bundle_to_profile = new Bundle();
        bundle_to_profile.putString("sign_in_date",signindate.getText().toString());
        bundle_to_profile.putString("user_id",userid.getText().toString());
        bundle_to_profile.putString("user_name",username.getText().toString());

        Intent intent_to_profile = new Intent(this, profile.class);
        intent_to_profile.putExtras(bundle_to_profile);
        startActivity(intent_to_profile);
    }


    private static final int PERMISSION_REQUEST_READ_FOLDERS = 1;

    public final void upload_image_button_clicked (View view) {
        String[] PERMISSIONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this,
                PERMISSIONS,
                PERMISSION_REQUEST_READ_FOLDERS);
    }

    // @Override
    // public boolean onCreateOptionsMenu(Menu menu) {
    //     MenuInflater inflater = getMenuInflater();
    //     inflater.inflate(R.menu.welcome_activity_menu, menu);
    //     return true;
    // }

    public boolean onOptionsItemSelected (MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }



    // @Override
    // public boolean onCreateOptionsMenu (Menu menu) {
    //     getMenuInflater().inflate(R.menu.welcome_activity_menu, menu);
    //     return true;
    // }

    // @Override
    // public boolean onOptionsItemSelected (MenuItem item) {
    //     int id = item.getItemId();
    //     if(id==R.id.go_back){
    //         Intent intent_go_back = new Intent(this, MainActivity.class);
    //         startActivity(intent_go_back);
    //     }
    //     return onOptionsItemSelected(item);
    // }



    // public void go_back(MenuItem item) {
    //     Intent intent_go_back = new Intent(this, MainActivity.class);
    //     startActivity(intent_go_back);
    // }
}