package com.pseudoi.app.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.pseudoi.app.model.BeerCraft;

import java.util.List;

@Dao
public interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMultipleListRecord(List<BeerCraft> universities);

    @Query("SELECT * FROM BeerCraft")
    List<BeerCraft> getAll();

    @Query("SELECT * FROM BeerCraft WHERE status LIKE :status")
    List<BeerCraft> getBeerCrafByStatus(String status);

    @Query("UPDATE BeerCraft SET status = :status WHERE entryId = :entryId")
    void updBeerCrafStatus (int entryId, String status);

    @Update
   void updBeerCrafStatus (BeerCraft beerCraft);

    @Query("SELECT * FROM BeerCraft WHERE name = :name")
    List<BeerCraft> getBeerCrafByName(String name);


}
