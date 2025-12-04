package com.zaknein.PokedexApi.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.zaknein.PokedexApi.domain.CapturePokemon;


@service
public class CapturedPokeServiceImpl implements CapturedPokeService {

    

    private Map<Integer,List<CapturedPokemon>> CaapturedPokeMap = new Hasmap<>();
    private List<CapturedPokemon> PokeList = new ArrayList<>();

    private int CapPokeId = PokeList.size() + 1;


    @Override
    public CapturedPokemon enterCapturedPoke() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterCapturedPoke'");
    }

    @Override
    public List<CapturedPokemon> getAllOfYourPoke() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOfYourPoke'");
    }

    @Override
    public void freePokeById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'freePokeById'");
    }
    
}
