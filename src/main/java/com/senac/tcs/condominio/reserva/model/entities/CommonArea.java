package com.senac.tcs.condominio.reserva.model.entities;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "CommonArea")
@Table(name = "CommonArea")
@Getter
@Setter
public class CommonArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 300)
    private String description;
    @Column(nullable = false)
    private Blob imagem;
    
    public CommonArea(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
