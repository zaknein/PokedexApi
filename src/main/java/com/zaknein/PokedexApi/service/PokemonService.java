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

    public void deletePokeById(int id){
        pokemonMap.remove(id);
    }

    public Pokemon updatePokemon(int id, PokemonCreater pokemonCreater){
        Pokemon oldPoke = pokemonMap.get(id);

        oldPoke.setName(pokemonCreater.getName());
        oldPoke.setDescription(pokemonCreater.getDescription());
        oldPoke.setSpecies(pokemonCreater.getSpecies());
        oldPoke.setHeight(pokemonCreater.getHeight());
        oldPoke.setWeight(pokemonCreater.getWeight());
        oldPoke.setTypes(pokemonCreater.getTypes());

        return oldPoke;

    }




}