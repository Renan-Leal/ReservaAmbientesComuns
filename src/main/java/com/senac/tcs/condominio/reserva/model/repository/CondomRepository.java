package com.senac.tcs.condominio.reserva.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.tcs.condominio.reserva.model.entities.Condom;

public interface CondomRepository extends JpaRepository<Condom, Long> {
    List<Condom> findByName(String name);
} 
