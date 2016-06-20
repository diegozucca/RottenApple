package com.example.diego.rottenappledesign;

/*
 * Classe che rappresenta un elemento della lista
 * @author RottenApple
 * @version 1.0
 */

public class ListData {

    //Varaibili che costituiscono un elemento della lista
    private int mImageID;
    private String mTitle;
    private String mDescription;
    private String mInformation;

    //Semplice costruttore che istanzia gli elementi dichiarati
    public ListData(int imageID, String mTitle, String description, String mInformation){
        this.mImageID = imageID;
        this.mTitle = mTitle;
        this.mDescription = description;
        this.mInformation = mInformation;
    }

    //Metodi set/get delle variabili globali

    public int getmImageID() {
        return mImageID;
    }

    public void setmImageID(int mImageID) {
        this.mImageID = mImageID;
    }

    public String getTitle(){ return mTitle; }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getInformation() {
        return mInformation;
    }

    public void setInformation(String information) {
        this.mInformation = information;
    }
}
