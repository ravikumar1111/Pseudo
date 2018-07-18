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

    @Query("SELECT * FROM BeerCraft where addedToChart = :addedToChart")
    List<BeerCraft> getBeerCrafById(boolean addedToChart);

    @Query("UPDATE BeerCraft SET entryId = :entryId WHERE addedToChart = :addedToChart")
    boolean getBeerCrafById1 (int entryId, boolean addedToChart);
}
