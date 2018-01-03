package com.example.edeleon8425.popfizzle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ContactUs extends AppCompatActivity {

    Button sendEmail;
    Button sendSMS;

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
                Intent intent1 = new Intent(ContactUs.this, PFhomePage.class);
                startActivity(intent1);
                break;
            case R.id.item2:
                Intent intent2 = new Intent(ContactUs.this, PFNewsPage.class);
                startActivity(intent2);
                break;
            case R.id.item4:
                Intent intent4 = new Intent(ContactUs.this, PFFunnyImages.class);
                startActivity(intent4);
                break;
            case R.id.item5:
                Intent intent5 = new Intent(ContactUs.this, ContactUs.class);
                startActivity(intent5);
                break;
            case R.id.item7:
                Intent intent7 = new Intent(ContactUs.this, PFLogin.class);
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
        setContentView(R.layout.activity_contact_us);

        sendSMS = (Button) findViewById(R.id.textButton);
        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
                sendIntent.setData(Uri.parse("sms:5195555555"));
                startActivity(sendIntent);
            }
        });
        sendEmail = (Button) findViewById(R.id.emailButton);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
                sendIntent.setData(Uri.parse("mailto:helpdesk@popfizzle.com"));
                startActivity(sendIntent);
            }
        });
    }
}

