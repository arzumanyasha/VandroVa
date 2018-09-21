package com.example.user.vandrova.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.user.vandrova.model.Review;

@Database(entities = {Review.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase singleton;
    private static final String DATABASE_NAME = "ReviewDb.db";


    public abstract ReviewDao reviewDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (singleton == null) {
            synchronized (AppDatabase.class) {
                if (singleton == null) {
                    singleton = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            DATABASE_NAME)
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return singleton;
    }

}
