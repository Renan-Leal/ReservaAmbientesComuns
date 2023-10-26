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
@Entity(name = "Condom")
@Table(name = "Condom")

public class Condom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birth;
    private String cpf;
    
    public Condom(String name, Date birth, String cpf) {
        this.name = name;
        this.birth = birth;
        this.cpf = cpf;
    }
}
