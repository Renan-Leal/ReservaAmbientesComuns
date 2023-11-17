package com.senac.tcs.condominio.reserva.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
    @Column(nullable = false, length = 250)
    private String name;
    @Column(nullable = false)
    private LocalDate birth;
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String password;
    
    public Condom(String name, LocalDate birth, String cpf, String password) {
        this.name = name;
        this.birth = birth;
        this.cpf = cpf;
        this.password = password;
    }
}
