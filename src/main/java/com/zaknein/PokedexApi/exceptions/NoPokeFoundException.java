package com.zaknein.PokedexApi.exceptions;

public class NoPokeFoundException extends RuntimeException {
    

    public NoPokeFoundException(String msg){
        super(msg);
    }


}