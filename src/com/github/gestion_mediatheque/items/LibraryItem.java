package com.github.gestion_mediatheque.items;

public interface LibraryItem {
    /**
     * Return the id of the item.
     * @return String
     */
    public String getId();

    /**
     * Return the title of the item.
     * @return String
     */
    public String getTitle();
}
