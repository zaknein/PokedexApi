package com.zaknein.PokedexApi.service;

import org.springframework.stereotype.Service;

import com.zaknein.PokedexApi.domain.CapturePokemon;
import com.zaknein.PokedexApi.domain.Pokemon;
import com.zaknein.PokedexApi.domain.PokemonCreater;
import com.zaknein.PokedexApi.exceptions.NoPokeFoundException;
import com.zaknein.PokedexApi.exceptions.PokeUnderUserException;
import com.zaknein.PokedexApi.repository.CapturedPokeRepository;
import com.zaknein.PokedexApi.repository.PokemonRepository;
import java.io.IOException;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final CapturedPokeRepository capturedPokeRepository;

    public PokemonService(PokemonRepository pokemonRepository, CapturedPokeRepository capturedPokeRepository ) throws IOException {
        this.pokemonRepository = pokemonRepository;
        this.capturedPokeRepository = capturedPokeRepository;
    }

    public Pokemon createPokemon(PokemonCreater pokemonC) {

        return pokemonRepository.createPokemon(pokemonC);

    }

    public List<Pokemon> getThemAll() {
        List<Pokemon> poke = pokemonRepository.getThemAll();

        if (poke.isEmpty() || poke == null) {
            throw new NoPokeFoundException("There is no pokemon to list");
        } else {
            return poke;
        }

    }

    public Pokemon pokeById(int id) {

        Pokemon poke = pokemonRepository.pokeById(id);
        if (poke == null) {
            throw new NoPokeFoundException("There is no pokemon with the id " + id + " try again");
        } else {
            return poke;
        }

    }

    public void deletePokeById(int id) {


        
        Pokemon poke = pokemonRepository.pokeById(id);
        if(poke ==null){
            throw new NoPokeFoundException("There is no pokemon with the id " + id + " try again");
        }

        CapturePokemon pokemon = capturedPokeRepository.getCapturePokeById(id);
        if(pokemon != null){
             throw new PokeUnderUserException("This poke with id " + id + " has been captured by an user and cannot be deleted");
        }
        pokemonRepository.deletePokeById(id);
 
        

    }

    public Pokemon updatePokemon(int id, PokemonCreater pokemonCreater) {

        Pokemon oldPoke = pokemonRepository.pokeById(id);
        if (oldPoke == null) {
            throw new NoPokeFoundException("There is no pokemon with the id " + id + " try again");
        } else {

            Pokemon newPoke = pokemonRepository.updatePokemon(id, pokemonCreater);

            return newPoke;
        }

    }
}