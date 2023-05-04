package com.example.example_with_services.config.exceptions;

public class NotFound extends RuntimeException{
        public NotFound(){

        }

        public NotFound(String msg){
            super(msg);
        }
}
