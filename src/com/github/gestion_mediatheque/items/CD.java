package com.github.gestion_mediatheque.items;

public class CD implements LibraryItem{
    private String id;
    private String title;
    private String artistName;
    private Integer tracksNumber;

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArtistName(){
        return this.artistName;
    }

    public Integer getTracksNumber(){
        return this.tracksNumber;
    }
}
