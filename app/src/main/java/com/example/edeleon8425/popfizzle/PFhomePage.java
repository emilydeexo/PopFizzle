package com.example.edeleon8425.popfizzle;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PFhomePage extends AppCompatActivity {

    Button findoutActivity;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.item1:
                Intent intent1 = new Intent(PFhomePage.this, PFhomePage.class);
                startActivity(intent1);
                break;
            case R.id.item2:
                Intent intent2 = new Intent(PFhomePage.this, PFNewsPage.class);
                startActivity(intent2);
                break;
            case R.id.item4:
                Intent intent4 = new Intent(PFhomePage.this, PFFunnyImages.class);
                startActivity(intent4);
                break;
            case R.id.item5:
                Intent intent5 = new Intent(PFhomePage.this, ContactUs.class);
                startActivity(intent5);
                break;
            case R.id.item7:
                Intent intent7 = new Intent(PFhomePage.this, PFLogin.class);
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
        setContentView(R.layout.activity_pfhome_page);

        findoutActivity = (Button) findViewById(R.id.nameButton);
        findoutActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    Toast.makeText(PFhomePage.this,"Username: "+User.getName,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
