package com.senac.tcs.condominio.reserva.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.tcs.condominio.reserva.model.entities.Reserve;
import com.senac.tcs.condominio.reserva.model.repository.ReserveRepository;
import com.senac.tcs.condominio.reserva.util.EntityException;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository repository;

    public List<Reserve> listAll() {
        return repository.findAll();
    }

    public Reserve register(Reserve reserve) {
        return repository.save(reserve);
    }

    public Reserve findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityException("Reserve", id));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
