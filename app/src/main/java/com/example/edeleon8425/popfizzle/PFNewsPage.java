package com.example.edeleon8425.popfizzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class PFNewsPage extends AppCompatActivity {

    NewsAdapter newsAdapter = null;
    ListView listView = null;
    SQLiteDB db = null;
    ArrayList<News> use = null;

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
                Intent intent1 = new Intent(PFNewsPage.this, PFhomePage.class);
                startActivity(intent1);
                break;
            case R.id.item2:
                Intent intent2 = new Intent(PFNewsPage.this, PFNewsPage.class);
                startActivity(intent2);
                break;
            case R.id.item4:
                Intent intent4 = new Intent(PFNewsPage.this, PFFunnyImages.class);
                startActivity(intent4);
                break;
            case R.id.item5:
                Intent intent5 = new Intent(PFNewsPage.this, ContactUs.class);
                startActivity(intent5);
                break;
            case R.id.item7:
                Intent intent7 = new Intent(PFNewsPage.this, PFLogin.class);
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
        setContentView(R.layout.activity_pfnews_page);
        db = new SQLiteDB(this);

        use = db.getData();
        newsAdapter = new NewsAdapter(this, R.layout.layout_news, use);

        listView = (ListView) findViewById(R.id.newsList);
        listView.setAdapter(newsAdapter);

    }
}