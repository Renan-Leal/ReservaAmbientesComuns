package com.senac.tcs.condominio.reserva.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.tcs.condominio.reserva.model.entities.Reserve;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
} 
