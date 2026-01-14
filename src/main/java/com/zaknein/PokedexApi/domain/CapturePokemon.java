package com.zaknein.PokedexApi.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
public class CapturePokemon{
    private int capturedId;
    private int pokemonId;
    private String nickname;
    private int level;
    private LocalDateTime capturedAt;


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

    public void setCapturedId(int capturedId){
        this.capturedId = capturedId;
    }
    public int getPokemonId(){
        return pokemonId;
    }

    public void setPokemonId(int pokemonId){
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