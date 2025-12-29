package com.zaknein.PokedexApi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.zaknein.PokedexApi.domain.ErrorResponse;
import com.zaknein.PokedexApi.domain.Pokemon;
import com.zaknein.PokedexApi.domain.PokemonCreater;
import com.zaknein.PokedexApi.exceptions.NoPokeFoundException;
import com.zaknein.PokedexApi.service.PokemonService;
import com.zaknein.PokedexApi.service.PokemonServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.naming.NoPermissionException;

@RestController
@CrossOrigin
public class PokemonController {

    private PokemonService pokeService;

    @Autowired
    public PokemonController(PokemonServiceImpl pokeService) {
        this.pokeService = pokeService;
    }

    @GetMapping("/health-check")
    public String getHealthCheck() {
        return "Heeell yeah all working up";
    }

    @GetMapping("/pokemon")
    public List<Pokemon> getPokemon() {

        List<Pokemon> poke =pokeService.getThemAll();

        if(poke.isEmpty() || poke == null){
            throw new NoPokeFoundException("There is no pokemon to list");
        }else{
            return pokeService.getThemAll();
        }

    }

    @ExceptionHandler(value = NoPokeFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFound(NoPokeFoundException ex) {

        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @GetMapping("/pokemon/{id}")
    public Pokemon getPokemonById(@PathVariable int id) {
        return pokeService.pokeById(id);
    }

    @PostMapping("/pokemon")
    public Pokemon createPokemon(@RequestBody PokemonCreater pokemonCreater) {
        return pokeService.createPokemon(pokemonCreater);
    }

    @PutMapping("/pokemon/{id}")
    public Pokemon updatePokemon(@PathVariable int id, @RequestBody PokemonCreater pokemonCreater) {
        Pokemon updated = pokeService.updatePokemon(id, pokemonCreater);
        return updated;
    }

    @DeleteMapping("/pokemon/{id}")
    public void deletePokemon(@PathVariable int id) {
        pokeService.deletePokeById(id);
    }

}