package com.zaknein.PokedexApi.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Pokemon {

    int id;
    String name;
    String species;
    Double height;
    Double weight;
    String description;
    LocalDateTime createdAt;
    List<String> types;

    public Pokemon() {
    }

    public Pokemon(int id, String name, String species, Double height, Double weight, String description,
            LocalDateTime createdAt,
            List<String> types) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.description = description;
        this.createdAt = createdAt;
        this.types = types;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}