package com.example.edeleon8425.popfizzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class PFhomePage extends AppCompatActivity {
    Button logoutActivity;

    NewsAdapter newsAdapter=null;
    ListView listView=null;
    SQLiteDB db=null;
    ArrayList<News> use=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfhome_page);

        db= new SQLiteDB(this);

        use=db.getData();
        newsAdapter= new NewsAdapter(this,R.layout.layout_news,use);

        listView = (ListView) findViewById(R.id.newsList);
        listView.setAdapter(newsAdapter);

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
