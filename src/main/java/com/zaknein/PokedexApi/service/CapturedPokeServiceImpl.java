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
    private List<CapturedPokemon> PokeList = new ArrayList<>();

    private int CapPokeId = PokeList.size() + 1;


    @Override
    public CapturedPokemon enterCapturedPoke(int id, CapturePokemon capturePokemon) {

        private int existingPokeId= capturePokemon.getPokemonId();
        private Pokemon pokemonS = pokeService.pokeById(existingPokeId);


        if(pokemonS != null){
            CapturedPokemon newCaptured = new CapturedPokemon(CapPokeId, capturePokemon.getPokemonId(), capturePokemon.getNickname(),
             capturePokemon.getLevel(), capturePokemon.getCapturedAt())

            PokeList.add(newCaptured);

            CapturedPokeMap.put(id, PokeList);
            return newCaptured;             
        }

    }

    @Override
    public List<CapturedPokemon> getAllOfYourPoke() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOfYourPoke'");
    }

    @Override
    public void freePokeById(int userId, int capturedId) {

        private List<CapturedPokemon> selectToFreeList = CapturedPokeMap.get(userId);

        selectToFreeList.removeIf(selectToFreeList.getCapPokeId().equals(capturedId));

    }
    
}
