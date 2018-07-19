package com.pseudoi.app.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity
public class BeerCraft {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int entryId;
    private int orderStatus;

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @SerializedName("abv")
    @Expose
    @ColumnInfo(name ="abv")
    private String abv;
    @SerializedName("ibu")
    @Expose
    @ColumnInfo(name ="ibu")
    private String ibu;
    @SerializedName("id")
    @Expose
    @ColumnInfo(name ="id")
    private Integer id;
    @SerializedName("name")
    @Expose
    @ColumnInfo(name ="name")
    private String name;
    @SerializedName("style")
    @Expose
    @ColumnInfo(name ="style")
    private String style;
    @SerializedName("ounces")
    @Expose
    @ColumnInfo(name ="ounces")
    private Double ounces;



    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Double getOunces() {
        return ounces;
    }

    public void setOunces(Double ounces) {
        this.ounces = ounces;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {

        return status;
    }

    @SerializedName("status")
    @Expose
    @ColumnInfo(name ="status")
    private String status;
}