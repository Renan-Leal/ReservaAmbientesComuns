package com.senac.tcs.condominio.reserva.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.senac.tcs.condominio.reserva.model.entities.Condom;

public interface CondomRepository extends JpaRepository<Condom, Long> {
    UserDetails findByName(String name);
} 
