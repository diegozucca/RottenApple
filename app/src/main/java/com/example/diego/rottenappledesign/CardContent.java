package com.example.diego.rottenappledesign;

/*
* Classe che crea gli oggetti che saranno contenuti nelle Card dell'activity CardsActivity:
* un immagine, un titolo, un sottotitolo, un testo nascosto (che verrà poi espanso) e un box di
* salvataggio per memorizzare i dati utili per usare l'action_button
*
* @author RottenApple
* @version 1.0
*/
public class CardContent {
    int photoId;
    String title;
    String subtitle;
    String hiddenText;
    String saveBoxText;

    /* Costruttore  con parametri della classe */
    CardContent(int photo, String title, String subtitle, String hiddenText,String saveBoxText){
        photoId=photo;
        this.title=title;
        this.subtitle=subtitle;
        this.hiddenText=hiddenText;
        this.saveBoxText=saveBoxText;
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

    String getSaveBosxText(){ return saveBoxText; }

    String getHiddenText(){ return hiddenText; }
}

