package com.github.gestion_mediatheque.items;

public class CD implements LibraryItem{
    private String id;
    private String title;

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }
}
