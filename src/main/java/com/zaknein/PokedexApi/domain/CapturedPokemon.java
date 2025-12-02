package com.zaknein.PokedexApi.domain;

import java.time.LocalDateTime;

public class CapturedPokemon{

    String nickname;
    int level;
    LocalDateTime capturedAt;

    public CapturedPokemon(){}

    public CapturedPokemon(String nickname, int level, LocalDateTime capturedAt){

        this.nickname = nickname;
        this.level = level;
        this.capturedAt = capturedAt;
    }

}