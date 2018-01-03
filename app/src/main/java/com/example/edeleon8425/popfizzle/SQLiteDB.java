package com.example.edeleon8425.popfizzle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteDB extends SQLiteOpenHelper {
    private SQLiteDatabase database;

    //Db Version
    private static final int Db_Version=1;

    //Db Name
    private static final String Db_Name="PopFizzleDB7";

    //table names
    private static final String Table_Name="Users";
    private static final String Table_Name1="Quizzes";
    private static final String Table_Name2="News";

    //Creating Users Columns
    private static final String User_id="id";
    private static final String User_name="uname";
    private static final String User_password="password";
    private static final String User_firstname="firstname";
    private static final String User_lastname="lastname";
    private static final String User_email="email";

    //Creating Quizzes Columns
    private static final String Quiz_id="id";
    private static final String Quiz_name="qname";
    private static final String Quiz_genre="qgenre";

    //Creating News Columns
    private static final String News_id="id";
    private static final String News_name="nname";
    private static final String News_genre="ngenre";

    public SQLiteDB(Context context)
    {
        super(context,Db_Name,null,Db_Version);
    }
    //creating table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // writing command for sqlite to create table with required columns
        String Create_Table="CREATE TABLE " + Table_Name + "(" + User_id
                + " INTEGER PRIMARY KEY," + User_name + " TEXT," + User_password  + " TEXT," +
                User_firstname + " TEXT," + User_lastname + " TEXT," + User_email + " TEXT" +")";

        String Create_TableQuiz="CREATE TABLE " + Table_Name1 + "(" + Quiz_id
                + " INTEGER PRIMARY KEY," + Quiz_name + " TEXT," + Quiz_genre  + " TEXT" +")";

        String Create_TableNews="CREATE TABLE " + Table_Name2 + "(" + News_id
                + " INTEGER PRIMARY KEY," + News_name + " TEXT," + News_genre  + " TEXT" +")";

        db.execSQL(Create_Table);
        db.execSQL(Create_TableQuiz);
        db.execSQL(Create_TableNews);
    }
    //Upgrading the Db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name1);
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name2);
        //create the table again
        onCreate(db);
    }
    //Add new User by calling this method
    public void addUser(User usr)
    {
        // getting db instance for writing the user
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(User_name,usr.getName());
        cv.put(User_password,usr.getPassword());
        cv.put(User_firstname,usr.getFirstname());
        cv.put(User_lastname,usr.getLastname());
        cv.put(User_email,usr.getEmail());
        //inserting row
        db.insert(Table_Name, null, cv);
        //close the database to avoid any leak
        db.close();
    }
    //Add new User by calling this method
    public void addNews(News newss)
    {
        // getting db instance for writing the user
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(News_name,newss.getName());
        cv.put(News_genre,newss.getGenre());
        //inserting row
        db.insert(Table_Name2, null, cv);
        //close the database to avoid any leak
        db.close();
    }
    public int checkUser(User us)
    {
        int id=-1;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT id FROM Users WHERE uname=? and password=?",new String[]{us.getName(),us.getPassword()});
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            id=cursor.getInt(0);
            cursor.close();
        }
        return id;
    }

    public ArrayList<News> getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<News> use= new ArrayList<News>();
        Cursor result = db.rawQuery("select * from "+Table_Name2 , null);
        while(result.moveToNext()){
            use.add( new News(result.getString(result.getColumnIndex(News_name)), result.getString(result.getColumnIndex(News_genre))));

        }
        return use;
    }
}

