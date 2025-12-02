package com.zaknein.PokedexApi.service;

import java.util.List;

import com.zaknein.PokedexApi.domain.CapturedPokemon;



public interface CapturedPokeService {

    CapturedPokemon enterCapturedPoke();

    List<CapturedPokemon> getAllOfYourPoke();

    void freePokeById(int id);
    

}
