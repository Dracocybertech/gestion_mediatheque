package com.github.gestion_mediatheque.items;

import java.util.List;

import com.github.gestion_mediatheque.people.Author;

public class Book implements LibraryItem{
    
    private String id;
    private static List<String> allIds;
    private String title;
    private List<Author> authors;

    public Book(String id, String title, List<Author> authors) throws NullTitleException, NullAuthorException, NonUniqueIdException{
        //Non empty title
        if (title == null || title.isEmpty()){
            throw new NullTitleException("Title cannot be empty. Please add a title with at least one character.");
        }
        //Non empty author
        if (authors.isEmpty()){
            throw new NullAuthorException("Book needs at least one author to be created.");
        }
        //Unique id
        if (allIds.contains(id)){
            throw new NonUniqueIdException("Id must be unique.");
        }
        this.title = title;
        this.authors = authors;
        this.id = id;

        //Add id to the list of all ids already existing
        allIds.add(id);
    }

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
