package com.senac.tcs.condominio.reserva.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.tcs.condominio.reserva.model.entities.Condom;
import com.senac.tcs.condominio.reserva.model.repository.CondomRepository;

@Service
public class CondomService {  

    @Autowired
    private CondomRepository repository;

    public List<Condom> listAll() {
        return repository.findAll();
    }
}
