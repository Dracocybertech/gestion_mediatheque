package com.github.gestion_mediatheque.library;

import java.util.HashMap;
import java.util.Map;

import com.github.gestion_mediatheque.items.LibraryItem;

public class LibraryManager {
    private Map<String, LibraryItem> mapItems;
    private static int MAX_SIZE = 100;

    /**
     * Constructor of LibraryManager
     */
    public LibraryManager() {
        this.mapItems = new HashMap<>();
    }
}
