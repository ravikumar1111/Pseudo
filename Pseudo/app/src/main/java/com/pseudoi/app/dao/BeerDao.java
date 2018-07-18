package com.pseudoi.app.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.pseudoi.app.model.BeerCraft;

import java.util.List;

@Dao
public interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMultipleListRecord(List<BeerCraft> universities);

    @Query("SELECT * FROM BeerCraft")
    List<BeerCraft> getAll();
}
