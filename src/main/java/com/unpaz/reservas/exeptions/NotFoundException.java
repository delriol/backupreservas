package com.unpaz.reservas.exeptions;

public class NotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public NotFoundException(String message){
        super("Elemento no encontrado : " + message);
    }
}
