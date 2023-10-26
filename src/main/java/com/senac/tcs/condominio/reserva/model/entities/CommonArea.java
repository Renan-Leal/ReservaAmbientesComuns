package com.senac.tcs.condominio.reserva.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "CommonArea")
@Table(name = "CommonArea")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CommonArea {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idCommomArea;
    private String name;
    private String description;
}
