package com.senac.tcs.condominio.reserva.util;

public class EntityException extends RuntimeException {
    public EntityException(String entity, Long id) {
        super("The entity " + entity + " with ID " + id + " was not found.");
    }
    
}
