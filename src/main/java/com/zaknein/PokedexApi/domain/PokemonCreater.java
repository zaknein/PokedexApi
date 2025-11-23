package com.zaknein.PokedexApi.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PokemonCreater {

    String name;
    String species;
    Double height;
    Double weight;
    String description;
    LocalDateTime createdAt;
    ArrayList<String> types;

    public PokemonCreater() {
    }

    public PokemonCreater(String name, String species, Double height, Double weight, String description,
            LocalDateTime createdAt,
            ArrayList<String> types) {
        this.name = name;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.description = description;
        this.createdAt = createdAt;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

}