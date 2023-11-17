package com.senac.tcs.condominio.reserva.model.dto;

import java.time.LocalDate;

public record CondomDTO(String name, LocalDate birth, String cpf, String password) {
    
}
