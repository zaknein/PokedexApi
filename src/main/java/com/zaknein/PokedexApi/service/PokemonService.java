package com.zaknein.PokedexApi.service;

import java.util.List;

import com.zaknein.PokedexApi.domain.Pokemon;
import com.zaknein.PokedexApi.domain.PokemonCreater;

public interface PokemonService {

    
    Pokemon createPokemon(PokemonCreater pokemonC );

    List<Pokemon> getThemAll();

    Pokemon pokeById(int id);

    void deletePokeById(int id);

    Pokemon updatePokemon(int id, PokemonCreater pokemonCreater);
}