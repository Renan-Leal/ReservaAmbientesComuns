package com.senac.tcs.condominio.reserva.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.tcs.condominio.reserva.model.entities.CommonArea;
import com.senac.tcs.condominio.reserva.model.repository.CommonAreaRepository;
import com.senac.tcs.condominio.reserva.util.EntityException;

@Service
public class CommonAreaService {

    @Autowired
    private CommonAreaRepository repository;

    public List<CommonArea> listAll() {
        return repository.findAll();
    }

    public CommonArea register(CommonArea commonArea) {
        return repository.save(commonArea);
    }

    public CommonArea findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityException("CommonArea", id));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
