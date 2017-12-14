package com.example.edeleon8425.popfizzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class PFcreateAccount extends AppCompatActivity {

    Button accountCreateActivity;
    Button loginCancelActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfcreate_account);


        loginCancelActivity = (Button)findViewById(R.id.cancelBtn);

        loginCancelActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Intent code for open new activity through intent.
                Intent intent = new Intent(PFcreateAccount.this, PFLogin.class);
                startActivity(intent);

            }
        });
        final EditText username = (EditText)findViewById(R.id.UsernameEditText);
        final EditText password = (EditText)findViewById(R.id.passwordEditText);
        final EditText reenterpassword = (EditText)findViewById(R.id.reenterPasswordEditText);
        final EditText firstname = (EditText)findViewById(R.id.firstnameEditText);
        final EditText lastname = (EditText)findViewById(R.id.lastnameEditText);
        final CheckBox check1 = (CheckBox) findViewById(R.id.checkBox1);
        final CheckBox check2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox check3 = (CheckBox) findViewById(R.id.checkBox3);

        accountCreateActivity = (Button)findViewById(R.id.createBtn);
        accountCreateActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("") || password.getText().toString().equals("")
                        || reenterpassword.getText().toString().equals("") || firstname.getText().toString().equals("")
                        || lastname.getText().toString().equals("") || !check1.isChecked()
                        || !check2.isChecked() || !check3.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Something is missing"
                            ,Toast.LENGTH_SHORT).show();
                }
                else {
                    // Intent code for open new activity through intent.
                    Intent intent = new Intent(PFcreateAccount.this, PFhomePage.class);
                    startActivity(intent);
                }

            }
        });

    }
}
