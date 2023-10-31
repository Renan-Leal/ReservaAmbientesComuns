package com.senac.tcs.condominio.reserva.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.tcs.condominio.reserva.model.entities.Reserve;
import com.senac.tcs.condominio.reserva.model.repository.ReserveRepository;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository repository;

    public List<Reserve> listAll() {
        return repository.findAll();
    }
}
