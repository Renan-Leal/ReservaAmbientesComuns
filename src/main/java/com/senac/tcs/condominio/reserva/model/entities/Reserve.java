package com.senac.tcs.condominio.reserva.model.entities;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Column(nullable = false)
    private LocalDate dtReserve;
    @ManyToOne
    @JoinColumn(name = "id_condom")
    private Condom condom;
    @ManyToOne
    @JoinColumn(name = "id_common_area")
    private CommonArea commonArea;
    
    public Reserve(LocalDate dtReserve, Condom condom, CommonArea commonArea) {
        this.dtReserve = dtReserve;
        this.condom = condom;
        this.commonArea = commonArea;
    }
}


