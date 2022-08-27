package com.example.recycleview;

import android.app.Application;

public class App extends Application {
    private static App instance;

    public static App getInstance() {
        if(instance == null) instance = new App();          //khởi tạo instance
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
