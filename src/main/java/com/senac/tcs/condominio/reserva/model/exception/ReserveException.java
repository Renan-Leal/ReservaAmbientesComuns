package com.senac.tcs.condominio.reserva.model.exception;

import java.time.LocalDate;

public class ReserveException extends Exception{
    public ReserveException(LocalDate date){
        super("There is a reservetion on the date:" + date);
    }
}
