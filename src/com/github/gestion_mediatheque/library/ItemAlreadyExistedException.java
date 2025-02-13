package com.github.gestion_mediatheque.library;

import com.github.gestion_mediatheque.items.LibraryItem;

public class ItemAlreadyExistedException extends Exception {
    /**
     * Exception raised for adding an item already in the list.
     * 
     * @param attributeName
     */
    public ItemAlreadyExistedException(LibraryItem item) {
        super("The item with the id " + item.getId() + " already existed");
    }
}
