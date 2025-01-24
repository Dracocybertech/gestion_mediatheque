package com.github.gestion_mediatheque.people;

public class NullNameException extends Exception {
    public NullNameException(){

    }

    public NullNameException(String msg){
        super(msg);
    }
}
