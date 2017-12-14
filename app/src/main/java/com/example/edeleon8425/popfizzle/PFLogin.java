package com.example.edeleon8425.popfizzle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PFLogin extends AppCompatActivity {

    Button loginActivity;
    private AppCompatTextView textViewLinkRegister;
    SQLiteDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pflogin);

        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);
        textViewLinkRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Intent code for open new activity through intent.
                Intent intent = new Intent(PFLogin.this, PFcreateAccount.class);
                startActivity(intent);
            }
        });

        final EditText username = (EditText) findViewById(R.id.UsernameEditTextLogin);
        final EditText password = (EditText) findViewById(R.id.passwordEditTextLogin);
        loginActivity = (Button) findViewById(R.id.loginButton);
        loginActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user_name = username.getText().toString();
                String upassword = password.getText().toString();
                int id= checkUser(new User(user_name,upassword));
                if (user_name.matches("") || upassword.matches("")) {
                    Toast.makeText(getApplicationContext(), "Something is missing"
                            , Toast.LENGTH_SHORT).show();
                }
                else if(id==-1)
                {
                    Toast.makeText(PFLogin.this,"User Does Not Exist",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(PFLogin.this,"User Exist "+ user_name,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PFLogin.this, PFhomePage.class);
                    startActivity(intent);
                }
            }
        });
        db=new SQLiteDB(PFLogin.this);
        //inserting dummy user
        db.addUser(new User("Admin", "Admin", "Admin", "Admin", "Admin"));
    }
    public int checkUser(User user)
        {
            return db.checkUser(user);
        }
}

