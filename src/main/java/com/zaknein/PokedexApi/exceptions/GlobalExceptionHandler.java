package com.zaknein.PokedexApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zaknein.PokedexApi.domain.ErrorResponse;


@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = NoPokeFoundException.class)
    public ErrorResponse notFound(NoPokeFoundException ex) {

        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = NoUserFoundException.class)
    public ErrorResponse notFound(NoUserFoundException ex) {

        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }


    @ExceptionHandler(value = PokeUnderUserException.class)
    public ErrorResponse badRequest(PokeUnderUserException ex) {

        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

}