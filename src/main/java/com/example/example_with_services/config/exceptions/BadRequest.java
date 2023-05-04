package com.example.example_with_services.config.exceptions;

public class BadRequest extends RuntimeException{

    public BadRequest(){

    }

    public BadRequest(String msg){
        super (msg);
    }

}
