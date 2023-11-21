package com.senac.tcs.condominio.reserva.model.dto;

import java.time.LocalDate;

import com.senac.tcs.condominio.reserva.model.entities.UserRole;

public record CondomDTO(String name, LocalDate birth, String cpf, String password, UserRole userRole) {
    
}
