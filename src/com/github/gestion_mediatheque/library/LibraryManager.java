package com.github.gestion_mediatheque.library;

import java.util.HashMap;
import java.util.Map;

import com.github.gestion_mediatheque.items.LibraryItem;

public class LibraryManager {
    private Map<String, LibraryItem> mapItems;
    private static int maxSize = 100;

    /**
     * Constructor of LibraryManager
     */
    public LibraryManager() {
        this.mapItems = new HashMap<>();
    }

    /**
     * Add any Item (CD or Book) to the library if the id doesn't exist.
     * 
     * @param item
     * @throws ItemAlreadyExistedException
     * @throws MaxSizeLibraryException
     */
    public void addItem(LibraryItem item) throws ItemAlreadyExistedException, MaxSizeLibraryException {
        if (mapItems.size() >= maxSize) {
            throw new MaxSizeLibraryException(
                    "The library has reached its maximum size of items. Remove items to add new ones.");
        }
        // Item must have a different id from the ones of the library
        if (mapItems.containsKey(item.getId())) {
            throw new ItemAlreadyExistedException(item);
        }
        mapItems.put(item.getId(), item);
    }

    /**
     * Return item with specific
     * 
     * @param id
     * @return LibraryItem
     */
    public LibraryItem getItem(String id) {
        return this.mapItems.get(id);
    }

    /**
     * Return the removed Book / CD from the library if it exists, otherwise return
     * null.
     * 
     * @param id
     * @return LibraryItem
     */
    public LibraryItem removeItem(String id) {
        return this.mapItems.remove(id);
    }

    /**
     * Return the max size of the library.
     * 
     * @return int
     */
    public int getMaxSize() {
        return LibraryManager.maxSize;
    }
}
