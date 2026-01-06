package com.zaknein.PokedexApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zaknein.PokedexApi.domain.ErrorResponse;
import com.zaknein.PokedexApi.exceptions.NoPokeFoundException;
import com.zaknein.PokedexApi.exceptions.PokeUnderUserException;


@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = NoPokeFoundException.class)
    public ErrorResponse notFound(NoPokeFoundException ex) {

        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = PokeUnderUserException.class)
    public ErrorResponse badRequest(PokeUnderUserException ex) {

        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

}