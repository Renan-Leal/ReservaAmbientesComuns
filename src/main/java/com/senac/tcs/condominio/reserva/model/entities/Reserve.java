package com.senac.tcs.condominio.reserva.model.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Reserve")
@Table(name = "Reserve")
public class Reserve {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dtReserve;
    private Condom condom;
    private CommonArea commonArea;
    
    public Reserve(Date dtReserve, Condom condom, CommonArea commonArea) {
        this.dtReserve = dtReserve;
        this.condom = condom;
        this.commonArea = commonArea;
    }
}


