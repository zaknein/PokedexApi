package com.zaknein.PokedexApi.domain;

import java.time.LocalDateTime;

public class CapturePokemon{
    int capturedId;
    int pokemonId;
    String nickname;
    int level;
    LocalDateTime capturedAt;


    public CapturePokemon(){}

    public CapturePokemon(int capturedId, int pokemonId, String nickname, int level, LocalDateTime capturedAt){
        this.capturedId = capturedId;
        this.pokemonId = pokemonId;
        this.nickname = nickname;
        this.level = level;
        this.capturedAt = capturedAt;
    }
    public int getCapturedId(){
        return capturedId;
    }

    public void setCapturedId(){
        this.capturedId = capturedId;
    }
    public int getPokemonId(){
        return pokemonId;
    }

    public void setPokemonId(){
        this.pokemonId = pokemonId;
    }
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LocalDateTime getCapturedAt() {
        return capturedAt;
    }
    
    public void setCapturedAt(LocalDateTime capturedAt) {
        this.capturedAt = capturedAt;
    }

}