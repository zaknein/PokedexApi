package com.zaknein.PokedexApi.service;

import java.util.List;

import com.zaknein.PokedexApi.domain.CapturePokemon;



public interface CapturedPokeService {

    CapturePokemon enterCapturedPoke(int id, CapturePokemon capturePokemon);

    List<CapturePokemon> getAllOfYourPoke(int id);

    void freePokeById(int userId, int capturedId);
    

}
