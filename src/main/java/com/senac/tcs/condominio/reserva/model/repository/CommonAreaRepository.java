package com.senac.tcs.condominio.reserva.model.repository;

import com.senac.tcs.condominio.reserva.model.entities.CommonArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonAreaRepository extends JpaRepository<CommonArea, String> {
}
