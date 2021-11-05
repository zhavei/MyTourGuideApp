package com.example.mytourguideapp;

import android.graphics.drawable.Drawable;

//this model data i get it from David tourguideapp repo

public class WorldDataModel {

    //name for inflating data
    private String name;
    private Drawable image = null;
    private Drawable imageThumbnail;
    private String address = "";
    private String website = "";
    private String deskription = "";
    private String share = "";

    //view model data for each item on list
    public WorldDataModel(String name, String address, Drawable imageThumbnail) {

        this.name = name;
        this.address = address;
        this.imageThumbnail = imageThumbnail;
    }

    //view model data for details activity
    public WorldDataModel(String name, Drawable image, String address, String website, String share, String deskription) {
        this.name = name;
        this.image = image;
        this.address = address;
        this.website = website;
        this.deskription = deskription;
        this.share = share;
    }


    //getters
    public String getName() {
        return name;
    }

    public Drawable getImage() {
        return image;
    }

    public Drawable getImageThumbnail() {
        return imageThumbnail;
    }

    public String getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public String getShare() {
        return share;
    }

    public String getDeskription() {
        return deskription;
    }
}
