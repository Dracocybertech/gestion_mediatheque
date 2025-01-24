package com.github.gestion_mediatheque.items;

public class NullTitleException extends Exception {
    public NullTitleException(){

    }

    public NullTitleException(String msg){
        super(msg);
    }
}
