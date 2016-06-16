package com.example.diego.rottenappledesign;

/*
* Classe che crea gli oggetti che saranno contenuti nelle Card dell'activity CardsActivity:
* un immagine, un titolo e un sottotitolo
* @author RottenApple
* @version 1.0
*/
public class CardContent {
    int photoId;
    String title;
    String subtitle;

    /* Costruttore  con parametri della classe */
    CardContent(int photo, String title, String subtitle){
        photoId=photo;
        this.title=title;
        this.subtitle=subtitle;
    }

    /* Metodo che ritorna l'id della foto specificata della card */
    int getPhotoId(){
        return photoId;
    }

    /* Metodo che ritorna il titolo della card */
    String getTitle(){
        return title;
    }

    /* Metodo che ritorna il sottotitolo della card */
    String getSubtitle(){
        return subtitle;
    }
}

