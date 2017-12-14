package com.example.edeleon8425.popfizzle;

import android.app.Application;
import com.facebook.stetho.Stetho;

/**
 * Created by edeleon8425 on 12/7/2017.
 */

public class stetho extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}