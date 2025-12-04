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


    private Map<Integer,List<CapturedPokemon>> CaapturedPokeMap = new Hasmap<>();
    private List<CapturedPokemon> PokeList = new ArrayList<>();

    private int CapPokeId = PokeList.size() + 1;


    @Override
    public CapturedPokemon enterCapturedPoke(int id, CapturePokemon capturePokemon) {

        private List<Pokemon> pokemonS = pokeService.getThemAll();

        if()

        CapturedPokemon newCaptured = new CapturedPokemon()




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
