package com.zaknein.PokedexApi.service;

import org.springframework.stereotype.Service;
import com.zaknein.PokedexApi.service.PokemonService;
import com.zaknein.PokedexApi.service.PokemonServiceImpl;
import com.zaknein.PokedexApi.domain.Pokemon;
import com.zaknein.PokedexApi.domain.CapturePokemon;

import java.util.List;
import java.util.HashMap;
import java.util.Map;




@service
public class CapturedPokeServiceImpl implements CapturedPokeService {

    private  PokemonService pokeService;

    @Autowired
    public PokemonController(PokemonServiceImpl pokeService){
        this.pokeService = pokeService;
    }


    private Map<Integer,List<CapturedPokemon>> CapturedPokeMap = new Hasmap<>();
    

    private int CapPokeId = PokeList.size() + 1;


    @Override
    public CapturedPokemon enterCapturedPoke(int id, CapturePokemon capturePokemon) {


        if(CapturedPokeMap.get(id) != null){
            List<CapturedPokemon> PokeList = CapturedPokeMap.get(userId);
            int existingPokeId= capturePokemon.getPokemonId();
            Pokemon pokemonS = pokeService.pokeById(existingPokeId);
            if(pokemonS != null){
                CapturedPokemon newCaptured = new CapturedPokemon(CapPokeId, capturePokemon.getPokemonId(), capturePokemon.getNickname(),
                capturePokemon.getLevel(), capturePokemon.getCapturedAt())

                PokeList.add(newCaptured);

                CapturedPokeMap.put(id, PokeList);
                return newCaptured;             
            }
        }
        // int existingPokeId= capturePokemon.getPokemonId();
        // Pokemon pokemonS = pokeService.pokeById(existingPokeId);
        // List<CapturedPokemon> PokeList = new ArrayList<>();

        // if(pokemonS != null){
        //     CapturedPokemon newCaptured = new CapturedPokemon(CapPokeId, capturePokemon.getPokemonId(), capturePokemon.getNickname(),
        //      capturePokemon.getLevel(), capturePokemon.getCapturedAt())

        //     PokeList.add(newCaptured);

        //     CapturedPokeMap.put(id, PokeList);
        //     return newCaptured;             
        // }
        return newCaptured;
    }

    @Override
    public List<CapturedPokemon> getAllOfYourPoke() {
        return List<CapturedPokemon> selectToFreeList = CapturedPokeMap.get(userId);
    }

    @Override
    public void freePokeById(int userId, int capturedId) {

        List<CapturedPokemon> selectToFreeList = CapturedPokeMap.get(userId);

        selectToFreeList.removeIf(selectToFreeList.getCapPokeId().equals(capturedId));

    }
    
}
