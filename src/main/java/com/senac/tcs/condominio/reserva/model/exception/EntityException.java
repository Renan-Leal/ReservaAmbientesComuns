package com.senac.tcs.condominio.reserva.model.exception;

public class EntityException extends RuntimeException {
    public EntityException(String entity, Long id) {
        super("The entity " + entity + " with ID " + id + " was not found.");
    }
}
