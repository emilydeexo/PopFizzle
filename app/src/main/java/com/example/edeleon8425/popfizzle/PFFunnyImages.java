package com.example.edeleon8425.popfizzle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class PFFunnyImages extends AppCompatActivity {
    String URL = "https://upload.wikimedia.org/wikipedia/en/4/4d/SpongeBob_SquarePants_characters_cast.png";
    ImageView image;
    Button button;
    ProgressDialog mProgressDialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent1 = new Intent(PFFunnyImages.this, PFhomePage.class);
                startActivity(intent1);
                break;
            case R.id.item2:
                Intent intent2 = new Intent(PFFunnyImages.this, PFNewsPage.class);
                startActivity(intent2);
                break;
            case R.id.item4:
                Intent intent4 = new Intent(PFFunnyImages.this, PFFunnyImages.class);
                startActivity(intent4);
                break;
            case R.id.item5:
                Intent intent5 = new Intent(PFFunnyImages.this, ContactUs.class);
                startActivity(intent5);
                break;
            case R.id.item7:
                Intent intent7 = new Intent(PFFunnyImages.this, PFLogin.class);
                startActivity(intent7);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pffunny_images);
        image = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.downloadButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                new PFFunnyImages.DownloadImage().execute(URL);
            }
        });
    }

        private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mProgressDialog = new ProgressDialog(PFFunnyImages.this);
                mProgressDialog.setTitle("Download Image Tutorial");
                mProgressDialog.setMessage("Loading...");
                mProgressDialog.setIndeterminate(false);
                mProgressDialog.show();
            }

            @Override
            protected Bitmap doInBackground(String... URL) {

                String imageURL = URL[0];

                Bitmap bitmap = null;
                try {
                    InputStream input = new java.net.URL(imageURL).openStream();
                    bitmap = BitmapFactory.decodeStream(input);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                image.setImageBitmap(result);
                mProgressDialog.dismiss();
            }
        }

}
