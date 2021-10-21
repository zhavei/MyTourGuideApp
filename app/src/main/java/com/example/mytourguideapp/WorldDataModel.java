package com.example.mytourguideapp;
import android.graphics.drawable.Drawable;

public class WorldDataModel {

    private String name;
    private Drawable image =null;
    private Drawable imageThumbnail;
    private String address = "";
    private String website= "";
    private String deskription = "";

    public WorldDataModel(String name, String address, Drawable imageThumbnail){
        this.name = name;
        this.address = address;
        this.imageThumbnail = imageThumbnail;
    }

    public WorldDataModel(String name, Drawable image, String address, String website, String deskription){
        this.name = name;
        this.image = image;
        this.address = address;
        this.website = website;
        this.deskription = deskription;
    }

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

    public String getDeskription() {
        return deskription;
    }
}
