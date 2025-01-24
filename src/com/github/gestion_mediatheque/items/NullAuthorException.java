package com.github.gestion_mediatheque.items;

public class NullAuthorException extends Exception {
    public NullAuthorException(){

    }

    public NullAuthorException(String msg){
        super(msg);
    }
}
