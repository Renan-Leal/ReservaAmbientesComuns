package com.senac.tcs.condominio.reserva.model.dto;

import java.time.LocalDate;

import com.senac.tcs.condominio.reserva.model.entities.CommonArea;
import com.senac.tcs.condominio.reserva.model.entities.Condom;

public record ReserveDTO(LocalDate dtReserve, Condom condom, CommonArea commonArea) {
    
}
