package com.example.diego.rottenappledesign;

/**
 *  Created by marco on 11/05/2016.
 */
public class CardContent {
    int photoId;
    String title;
    String subtitle;
    CardContent(int photo, String title, String subtitle){
        photoId=photo;
        this.title=title;
        this.subtitle=subtitle;
    }
    int getPhotoId(){
        return photoId;
    }
    String getTitle(){
        return title;
    }
    String getSubtitle(){
        return subtitle;
    }
}

