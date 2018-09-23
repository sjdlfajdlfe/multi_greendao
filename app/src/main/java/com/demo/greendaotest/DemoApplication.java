package com.demo.greendaotest;

import android.app.Application;
import android.content.Context;

/**
 * Created by liuwenji on 2018/9/22.
 */

public class DemoApplication extends Application {

    public static Context application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = getApplicationContext();
    }
}
