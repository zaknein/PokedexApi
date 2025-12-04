package com.zaknein.PokedexApi.domain;

import java.time.LocalDateTime;

public class CapturePokemon{

    String nickname;
    int level;
    LocalDateTime capturedAt;


    public void setCapturedAt(LocalDateTime capturedAt) {
        this.capturedAt = capturedAt;
    }

    public CapturePokemon(){}

    public CapturePokemon(String nickname, int level, LocalDateTime capturedAt){

        this.nickname = nickname;
        this.level = level;
        this.capturedAt = capturedAt;
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
}