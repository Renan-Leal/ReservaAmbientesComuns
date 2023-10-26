package com.senac.tcs.condominio.reserva.model.dto;

import java.sql.Date;

import com.senac.tcs.condominio.reserva.model.entities.CommonArea;
import com.senac.tcs.condominio.reserva.model.entities.Condom;

public record ReserveDTO(Date dtReserve, Condom condom, CommonArea commonArea) {
 
    
}
