package com.zaknein.PokedexApi;

import java.time.LocalDateTime;


public class Pokemon{

    int id;
    String name;
    String species;
    Double height;
    Double weight;
    String description;
    LocalDateTime  createdAt;    
    ArrayList<String> types;


    public Pokemon(){}

    public Pokemon (int id, String name, String species, Double height, Double weight, String description, LocalDateTime createdAt, 
    ArrayList<String> types){
        this.id = id;
        this.name = name;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.description = description;
        this.createdAt = createdAt;
        this.types = types;
    }

}