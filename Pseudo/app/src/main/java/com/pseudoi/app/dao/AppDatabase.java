package com.pseudoi.app.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.pseudoi.app.model.BeerCraft;

@Database(entities = {BeerCraft.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BeerDao beerDao();
}
