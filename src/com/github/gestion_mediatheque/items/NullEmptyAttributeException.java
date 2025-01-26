package com.github.gestion_mediatheque.items;

public class NullEmptyAttributeException extends Exception {
    /**
     * Exception raised for empty or null attributes at the creation of an object. 
     * @param attributeName 
     */
    public NullEmptyAttributeException(String attributeName) {
        super("The attribute " + attributeName + "can't be null nor empty.");
    }
}
