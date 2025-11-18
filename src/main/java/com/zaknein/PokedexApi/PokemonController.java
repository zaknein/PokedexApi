package com.zaknein.PokedexApi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin
public class PokemonController{

    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "Heeell yeah all working up";
    }


    @GetMapping("/pokemon")
    public String getPokemon(){
        /* GET POKEMON */
    }

    @GetMapping("/pokemon/id}")
    public String getPokemonById(@PathVariable int id){
        /* GET POKEMON BY ID */
    }
    
    @PostMapping("/pokemon")
    public Pokemon createPokemon(@RequestBody PokemonCreater pokemonCreater){
        /*POST POKEMON */
    }




}