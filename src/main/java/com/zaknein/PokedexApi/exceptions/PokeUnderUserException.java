package com.zaknein.PokedexApi.exceptions;

public class PokeUnderUserException extends RuntimeException {


    private String message;

    public PokeUnderUserException(String msg){
        super(msg);
        this.message = msg;
    }

    public String getMessage() {
       return message;
    }
    
}
