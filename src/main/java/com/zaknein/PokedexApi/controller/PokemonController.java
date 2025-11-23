package com.zaknein.PokedexApi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.zaknein.PokedexApi.domain.Pokemon;
import com.zaknein.PokedexApi.domain.PokemonCreater;
import com.zaknein.PokedexApi.service.PokemonService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;








@RestController
@CrossOrigin
public class PokemonController{

    private final PokemonService pokeService;

    @Autowired
    public PokemonController(PokemonService pokeService){
        this.pokeService = pokeService;
    }


    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "Heeell yeah all working up";
    }


    @GetMapping("/pokemon")
    public List<Pokemon> getPokemon(){
        return pokeService.getThemAll();

    }

    @GetMapping("/pokemon/{id}")
    public Pokemon getPokemonById(@PathVariable int id){
        return pokeService.pokeById(id);
    }
    
    @PostMapping("/pokemon")
    public Pokemon createPokemon(@RequestBody PokemonCreater pokemonCreater){
        return pokeService.createPokemon(pokemonCreater);
    }

    // @PutMapping("/pokemon/{id}")
    // public Pokemon updatePokemon(@PathVariable int id, @RequestBody PokemonCreater pokemonCreater ){
    //     /* UPGRADE POKEMON */
    // }

    // @DeleteMapping("/pokemon/{id}")
    // public Pokemon deletePokemon(@PathVariable int id){
    //     /*KILL POKEMON */
    // }



}