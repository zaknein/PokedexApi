package com.zaknein.PokedexApi.service;


import org.springframework.stereotype.Service;
import java.util.HashMap;



@Service
public class PokemonService{

    private Map<Integer,Pokemon> pokemonMap = new HashMap<>();

    private int futurePokeId = 1;

    @Override
    public Pokemon createPokemon(PokemonCreater pokemonC ){

        int pokemonId = futurePkmnId++;

        Pokemon newPoke = new Pokemon(pokemonId, PokemonC.getName, PokemonC.getSpecies, pokemonC.getHeight,
         pokemonC.getWeight, pokemonC.getDescription, pokemonC.getCreatedAt, pokemonC.getTypes)

        pokemonMap.put(pokemonId, newPoke);

    }










}