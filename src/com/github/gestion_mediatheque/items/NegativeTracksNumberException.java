package com.github.gestion_mediatheque.items;

public class NegativeTracksNumberException extends Exception{
    
    /**
     * Exception raised when the number of tracks is strictly less than 0 or null.
     */
    public NegativeTracksNumberException(){
        super("The number of tracks can't be null or below 0.");
    }
}
