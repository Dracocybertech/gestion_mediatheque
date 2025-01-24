package com.github.gestion_mediatheque.people;

import java.time.LocalDate;

public class Author {
    private String id;
    private String name;
    private LocalDate birthdate;
    private String nationality;

    public Author(String name) throws NullNameException{
        //Non empty name
        if (name.isEmpty()){
            throw new NullNameException("Name can't be null.");
        }
        this.name = name;
    }

    public Author(String name, String id) throws NullNameException {
        this(name);
        this.id = id;
    }

    public Author(String name, String id, LocalDate birthdate, String nationality) throws NullNameException {
        this(name, id);
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getBirthDate(){
        return this.birthdate;
    }

    public String getNationality(){
        return this.nationality;
    }
}
