package com.zaknein.PokedexApi.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.zaknein.PokedexApi.domain.CapturedPokemon;



public class CapturedPokeServiceImpl implements CapturedPokeService {

    private Map<Integer,CapturedPokemon> CaapturedPokeMap = new Hasmap<>();

    private int CapPokeId = 1;

    
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
