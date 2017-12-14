package com.example.edeleon8425.popfizzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PFhomePage extends AppCompatActivity {
    Button logoutActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfhome_page);
        logoutActivity = (Button)findViewById(R.id.logoutButton);
        logoutActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Intent code for open new activity through intent.
                Intent intent = new Intent(PFhomePage.this, PFLogin.class);
                startActivity(intent);
            }
        });
    }
}
