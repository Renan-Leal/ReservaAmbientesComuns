package com.senac.tcs.condominio.reserva.model.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.tcs.condominio.reserva.model.entities.Reserve;
import com.senac.tcs.condominio.reserva.model.exception.EntityException;
import com.senac.tcs.condominio.reserva.model.exception.ReserveException;
import com.senac.tcs.condominio.reserva.model.repository.ReserveRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository repository;
    @Autowired
    private EntityManager entityManager;

    public List<Reserve> listAll() {
        return repository.findAll();
    }

    public Reserve register(Reserve reserve) throws ReserveException {
        if(this.validateReserveDate(reserve.getDtReserve())) {
            throw new ReserveException(reserve.getDtReserve());
        }
        return repository.save(reserve);
    }

    public Reserve findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityException("Reserve", id));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private boolean validateReserveDate(LocalDate date){
        String sql = "SELECT e FROM e.dtreserve = :date";
        TypedQuery<Reserve> query = entityManager.createQuery(sql, Reserve.class);
        query.setParameter("date", date);
        List<Reserve> results = query.getResultList();
        return !results.isEmpty();
    }
}
