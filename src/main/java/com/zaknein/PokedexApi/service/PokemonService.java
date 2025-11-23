package com.zaknein.PokedexApi.service;


import org.springframework.stereotype.Service;

import com.zaknein.PokedexApi.domain.Pokemon;
import com.zaknein.PokedexApi.domain.PokemonCreater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class PokemonService{

    private Map<Integer,Pokemon> pokemonMap = new HashMap<>();

    private int futurePokeId = 1;

    public Pokemon createPokemon(PokemonCreater pokemonC ){

        int pokemonId = futurePokeId++;

        Pokemon newPoke = new Pokemon(pokemonId, pokemonC.getName(), pokemonC.getSpecies(), pokemonC.getHeight(),
         pokemonC.getWeight(), pokemonC.getDescription(), pokemonC.getCreatedAt(), pokemonC.getTypes());

        pokemonMap.put(pokemonId, newPoke);
        return null;
    
    }

    public List<Pokemon> getThemAll(){
        return new ArrayList(pokemonMap.values());
    }

    public Pokemon pokeById(int id){
        return pokemonMap.get(id);
    }








}