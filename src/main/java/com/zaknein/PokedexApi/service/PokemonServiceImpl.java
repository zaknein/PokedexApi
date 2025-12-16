package com.zaknein.PokedexApi.service;


import org.springframework.stereotype.Service;

import com.zaknein.PokedexApi.domain.Pokemon;
import com.zaknein.PokedexApi.domain.PokemonCreater;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class PokemonServiceImpl implements PokemonService {

    private static final File pokeFile = new File("pokedex.json");
    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    

    private Map<Integer,Pokemon> pokemonMap = new HashMap<>();

    public PokemonServiceImpl() throws IOException {
        if (pokeFile.exists()) {
            pokemonMap = mapper.readValue(pokeFile, mapper.getTypeFactory().constructMapLikeType(HashMap.class, Integer.class, Pokemon.class));
        } else {
            pokemonMap = new HashMap<>();
        }
    }

    private int futurePokeId = 1;


    @Override
    public Pokemon createPokemon(PokemonCreater pokemonC ){

        int pokemonId = futurePokeId++;

        Pokemon newPoke = new Pokemon(pokemonId, pokemonC.getName(), pokemonC.getSpecies(), pokemonC.getHeight(),
         pokemonC.getWeight(), pokemonC.getDescription(), pokemonC.getCreatedAt(), pokemonC.getTypes());

        pokemonMap.put(pokemonId, newPoke);
        sync();
        return newPoke;
    
    }

    @Override
    public List<Pokemon> getThemAll(){
        return new ArrayList(pokemonMap.values());
    }

    @Override
    public Pokemon pokeById(int id){
        return pokemonMap.get(id);
    }

    @Override
    public void deletePokeById(int id){
        pokemonMap.remove(id);
        sync();
    }

    @Override
    public Pokemon updatePokemon(int id, PokemonCreater pokemonCreater){
        Pokemon oldPoke = pokemonMap.get(id);

        oldPoke.setName(pokemonCreater.getName());
        oldPoke.setDescription(pokemonCreater.getDescription());
        oldPoke.setSpecies(pokemonCreater.getSpecies());
        oldPoke.setHeight(pokemonCreater.getHeight());
        oldPoke.setWeight(pokemonCreater.getWeight());
        oldPoke.setTypes(pokemonCreater.getTypes());

        sync();

        return oldPoke;

    }

    public void sync(){
        try{
            mapper.writeValue(pokeFile, pokemonMap);
        }catch (IOException e) {
            System.out.println("No existe archivo");
            e.printStackTrace();
        }
    }



}