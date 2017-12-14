package com.example.edeleon8425.popfizzle;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PFLogin extends AppCompatActivity {

    Button createAccountActivity;
    Button loginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pflogin);

        createAccountActivity = (Button)findViewById(R.id.createAccountButton);
        createAccountActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Intent code for open new activity through intent.
                Intent intent = new Intent(PFLogin.this, PFcreateAccount.class);
                startActivity(intent);

            }
        });

        final EditText username = (EditText)findViewById(R.id.UsernameEditText);
        final EditText password = (EditText)findViewById(R.id.passwordEditText);
        loginActivity = (Button)findViewById(R.id.loginButton);
        loginActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin")
                        && password.getText().toString().equals("admin")) {
                    // Intent code for open new activity through intent.
                    Intent intent = new Intent(PFLogin.this, PFhomePage.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials"
                            ,Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
