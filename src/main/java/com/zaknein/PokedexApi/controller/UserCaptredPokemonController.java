package com.zaknein.PokedexApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @GetMapping("/users/{userId}/pokemons")
    public List<CapturePokemon>  getCapturedPokemon(@PathVariable int id) {
        return CapPoke.getAllOfYourPoke(id);
    }
        
    @PostMapping("/users/{userId}/pokemons")
    public CapturePokemon postCapturedPokemon(@PathVariable int userId, @RequestBody CapturePokemon capturePokemon) {
  
        return CapPoke.enterCapturedPoke(userId, capturePokemon);
    }
    
    @DeleteMapping("/users/{userId}/pokemons/{capturedId}")
    public void deleteCapturedPokemon(@PathVariable int id, int capturedId){
        CapPoke.freePokeById(id, capturedId);
    }

}
