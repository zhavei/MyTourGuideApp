package com.example.mytourguideapp;

public class WordDataModel {
    private String laDefaultTranslation;

    private String indoAppTranslation;

    private int imageDrawable = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


    public WordDataModel(String defaultTrasnlation, String languangeTranslation, int imageIcon) {
        laDefaultTranslation = defaultTrasnlation;
        indoAppTranslation = languangeTranslation;
        imageDrawable = imageIcon;

    }

    // make method untuk yng tidak ada image
    public WordDataModel(String defaultTrasnlation, String languangeTranslation) {
        laDefaultTranslation = defaultTrasnlation;
        indoAppTranslation = languangeTranslation;
    }

    //  method chek apakah ada image atau tidak
    public boolean hasImage() {
        return imageDrawable != NO_IMAGE_PROVIDED;
    }

    public String getDefaultTrasnlation() {
        return laDefaultTranslation;
    }

    public String getLanguangeTranslation() {
        return indoAppTranslation;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

}
