package com.example.recycleview;

import android.app.Application;

public class App extends Application {
    private static App instance;

    private String text;
    private Storage storage;


    public static App getInstance() {
        if(instance == null) instance = new App();
        return instance;
    }

    public Storage getStorage(){
        return storage;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        storage=new Storage();
    }
}
