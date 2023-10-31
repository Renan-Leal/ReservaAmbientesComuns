package com.senac.tcs.condominio.reserva.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.tcs.condominio.reserva.model.entities.CommonArea;
import com.senac.tcs.condominio.reserva.model.repository.CommonAreaRepository;

@Service
public class CommonAreaService {

    @Autowired
    private CommonAreaRepository repository;

    public List<CommonArea> listAll() {
        return repository.findAll();
    }
}
