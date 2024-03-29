package com.example.subwayfinder.database;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;


@androidx.room.Database(entities = {Brt.class,Metro.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract Dao dao();

    private static Database instance;

    public static synchronized Database getInstance(Context context) {
        if (instance == null)
            return instance = Room.databaseBuilder(context, Database.class, "station").createFromAsset("station.db").build();
        return instance;
    }
}
