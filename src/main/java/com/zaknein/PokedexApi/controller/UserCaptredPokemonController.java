package com.zaknein.PokedexApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaknein.PokedexApi.domain.Pokemon;
import com.zaknein.PokedexApi.service.CapturedPokeService;
import com.zaknein.PokedexApi.service.CapturedPokeServiceImpl;
import com.zaknein.PokedexApi.domain.CapturePokemon;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@CrossOrigin
public class UserCaptredPokemonController {

    private CapturedPokeService CapPoke;

    @Autowired
    public UserCaptredPokemonController(CapturedPokeServiceImpl CapPoke){
        this.CapPoke = CapPoke;        
    }

    
    // @GetMapping("/users/{userId}/pokemons")
    // public Pokemon getCapturedPokemon(@PathVariable int id) {
    //     return 
    // }
        

    @PostMapping("/users/{userId}/pokemons")
    public Pokemon postCapturedPokemon(@PathVariable int id, @RequestBody CapturePokemon capturePokemon) {
  
        return CapPoke.enterCapturedPoke(id, capturePokemon);
    }
    
    @DeleteMapping("/users/{userId}/pokemons/{capturedId}")
    public void deleteCapturedPokemon(@PathVariable int id, int capturedId){
        CapPoke.freePokeById(id, capturedId)
    }

}
