package com.github.gestion_mediatheque.items;

import java.util.List;

import com.github.gestion_mediatheque.people.Author;

public class Book implements LibraryItem{
    
    private String id;
    private String title;
    private List<Author> authors;

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public List<Author> getAuthors(){
        return this.authors;
    }
}
