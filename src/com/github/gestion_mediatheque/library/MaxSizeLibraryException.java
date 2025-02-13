package com.github.gestion_mediatheque.library;

public class MaxSizeLibraryException extends Exception {
    public MaxSizeLibraryException(){

    }

    public MaxSizeLibraryException(String msg){
        super(msg);
    }
}
