package com.zaknein.PokedexApi.exceptions;

public class NoUserFoundException extends RuntimeException {
    
    private String message;

    public NoUserFoundException(String msg){
        super(msg);
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

}