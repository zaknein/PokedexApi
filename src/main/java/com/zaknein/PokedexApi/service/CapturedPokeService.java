package com.zaknein.PokedexApi.service;

import org.springframework.stereotype.Service;
import com.zaknein.PokedexApi.domain.Pokemon;
import com.zaknein.PokedexApi.exceptions.NoPokeFoundException;
import com.zaknein.PokedexApi.exceptions.NoUserFoundException;
import com.zaknein.PokedexApi.repository.CapturedPokeRepository;
import com.zaknein.PokedexApi.repository.PokemonRepository;
import com.zaknein.PokedexApi.domain.CapturePokemon;

import java.util.List;
import java.io.IOException;


@Service
public class CapturedPokeService {
    
    private final PokemonRepository pokemonRepository;
    private final CapturedPokeRepository capturedPokeRepository;


    public CapturedPokeService(PokemonRepository pokemonRepository, CapturedPokeRepository capturedPokeRepository) throws IOException {
        this.pokemonRepository = pokemonRepository;
        this.capturedPokeRepository = capturedPokeRepository;
    }

    public CapturePokemon enterCapturedPoke(int userId, CapturePokemon capturePokemon) {
        

        int pokeIdToCapture = capturePokemon.getPokemonId();
        Pokemon pokemon = pokemonRepository.pokeById(pokeIdToCapture);
        if (pokemon != null) {
            
            return capturedPokeRepository.enterCapturedPoke(userId, capturePokemon);
         
            
        } else {
            throw new NoPokeFoundException("There is no pokemon with the id " + pokeIdToCapture + " try again");
        }
    }

    public List<CapturePokemon> getAllOfYourPoke(int userId) {
        List<CapturePokemon> allPokeList = capturedPokeRepository.getAllOfYourPoke(userId);
        if(allPokeList.isEmpty()){
            throw new NoUserFoundException("There is no user with the id " +userId+ " try again");
        }
        return allPokeList;
    }

    public void freePokeById(int userId, Integer capturedId) {

        capturedPokeRepository.freePokeById(userId, capturedId);
    }
}
