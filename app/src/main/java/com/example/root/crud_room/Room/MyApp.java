package com.example.root.crud_room.Room;

import android.app.Application;
import android.arch.persistence.room.Room;

/**
 * Created by khoiron on 27/01/18.
 */

public class MyApp extends Application {

    public static AppDatabase db;
    
    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"mahasiswa").allowMainThreadQueries().build();
    }

}
