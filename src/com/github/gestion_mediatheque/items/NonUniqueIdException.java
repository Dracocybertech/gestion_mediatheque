package com.github.gestion_mediatheque.items;

public class NonUniqueIdException extends Exception {
    public NonUniqueIdException(){

    }

    public NonUniqueIdException(String msg){
        super(msg);
    }
}
