package com.worldpay.offer.exception;


import com.worldpay.offer.model.common.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleNoSuchElementException(){
        return new Error("Offer ID does not exist",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleNumberFormatException(){
        return new Error("Offer ID needs to be a numeric value",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Error handleGenericException(){
        return new Error("Something went wrong handling the request",HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
