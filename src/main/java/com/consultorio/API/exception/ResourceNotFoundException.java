package com.consultorio.API.exception;


//extension y creacion de la excepcion
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {

        super(message);
    }
}
