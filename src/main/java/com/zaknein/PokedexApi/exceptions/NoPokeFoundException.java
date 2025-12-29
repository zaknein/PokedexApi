package com.zaknein.PokedexApi.exceptions;

public class NoPokeFoundException extends RuntimeException {
    
    private String message;

    public NoPokeFoundException(String msg){
        super(msg);
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

}