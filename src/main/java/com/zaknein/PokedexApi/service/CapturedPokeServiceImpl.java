package com.zaknein.PokedexApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zaknein.PokedexApi.domain.Pokemon;
import com.zaknein.PokedexApi.domain.CapturePokemon;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Service
public class CapturedPokeServiceImpl implements CapturedPokeService {

    private  PokemonService pokeService;

    @Autowired
    public void PokemonController(PokemonServiceImpl pokeService){
        this.pokeService = pokeService;
    }

    private Map<Integer,List<CapturePokemon>> CapturedPokeMap = new HashMap<>();
    

    @Override
    public CapturePokemon enterCapturedPoke(int id, CapturePokemon capturePokemon) {

        CapturePokemon newCaptured = null;
        if(CapturedPokeMap.get(id) != null){
            List<CapturePokemon> PokeList = CapturedPokeMap.get(id);
            int existingPokeId= capturePokemon.getPokemonId();
            Pokemon pokemonS = pokeService.pokeById(existingPokeId);
            int CapPokeId = PokeList.size();
            CapPokeId ++;
            if(pokemonS != null){
                newCaptured = new CapturePokemon(CapPokeId, capturePokemon.getPokemonId(), capturePokemon.getNickname(),
                capturePokemon.getLevel(), capturePokemon.getCapturedAt());

                PokeList.add(newCaptured);

                CapturedPokeMap.put(id, PokeList);
                return newCaptured;             
            }
        }else{
            List<CapturePokemon> PokeList = new ArrayList<>();
            int existingPokeId= capturePokemon.getPokemonId();
            Pokemon pokemonS = pokeService.pokeById(existingPokeId);
            int CapPokeId = PokeList.size();
            CapPokeId ++;
            if(pokemonS != null){
                newCaptured = new CapturePokemon(CapPokeId, capturePokemon.getPokemonId(), capturePokemon.getNickname(),
                capturePokemon.getLevel(), capturePokemon.getCapturedAt());

                PokeList.add(newCaptured);

                CapturedPokeMap.put(id, PokeList);
                return newCaptured;             
            }
        }
        return newCaptured;
    }

    @Override
    public List<CapturePokemon> getAllOfYourPoke(int userId) {
        List<CapturePokemon> allPokeList = CapturedPokeMap.get(userId);
        return allPokeList;
    }

    @Override
    public void freePokeById(int userId, Integer capturedId) {

        List<CapturePokemon> selectToFreeList = CapturedPokeMap.get(userId);

        if(selectToFreeList != null){
            Iterator<CapturePokemon> iterator = selectToFreeList.iterator();
            while(iterator.hasNext()){
                CapturePokemon poke = iterator.next();

                if(poke.getCapturedId() == capturedId){
                    iterator.remove();
                }
            }
        }


    }

}
