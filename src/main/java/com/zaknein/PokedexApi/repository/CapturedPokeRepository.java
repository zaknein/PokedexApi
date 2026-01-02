package com.zaknein.PokedexApi.repository;

import java.util.List;

import com.zaknein.PokedexApi.domain.CapturePokemon;



public interface CapturedPokeRepository {

    CapturePokemon enterCapturedPoke(int id, CapturePokemon capturePokemon);

    List<CapturePokemon> getAllOfYourPoke(int id);

    void freePokeById(int userId, Integer capturedId);
}
