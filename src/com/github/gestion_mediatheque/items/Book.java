package com.github.gestion_mediatheque.items;

import java.util.List;

import com.github.gestion_mediatheque.people.Author;

public class Book implements LibraryItem {

    private String id;
    private String title;
    private List<Author> authors;

    public Book(String id, String title, List<Author> authors) throws NullEmptyAttributeException {
        // Non empty title
        if (title == null || title.isEmpty()) {
            throw new NullEmptyAttributeException("title");
        }
        // Non empty author
        if (authors == null || authors.isEmpty()) {
            throw new NullEmptyAttributeException("authors");
        }

        this.title = title;
        this.authors = authors;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }
}
