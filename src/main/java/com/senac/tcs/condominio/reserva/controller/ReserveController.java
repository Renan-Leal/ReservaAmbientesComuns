package com.senac.tcs.condominio.reserva.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.tcs.condominio.reserva.model.entities.Reserve;
import com.senac.tcs.condominio.reserva.model.exception.EntityException;
import com.senac.tcs.condominio.reserva.model.exception.ReserveException;
import com.senac.tcs.condominio.reserva.model.service.ReserveService;

@RestController
@RequestMapping("/reserve")
public class ReserveController {
    
    @Autowired
    private ReserveService service;
    
    @GetMapping("/listAll")
    public List<Reserve> listAll() {
        return service.listAll();
    }

    @PostMapping("/register")
    public Reserve register(@RequestBody Reserve reserve) throws ReserveException {
        Reserve registeredReserve = service.register(reserve);
        return registeredReserve;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Reserve deletedReserve = service.findById(id);
        if (deletedReserve != null) {
            service.deleteById(id);
        }
        return ResponseEntity.ok(deletedReserve);
    }

    @GetMapping("/{id}")
    public Reserve listById(@PathVariable Long id) {
        Reserve reserve = service.findById(id);
        return reserve;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Reserve reserve) {
        Reserve currentReserve = service.findById(id);
        if (currentReserve.getId() != null) {
            reserve.setId(id);
            //currentReserve = service.register(reserve); TODO fazer uma sobrecarga do método ou criar um novo
        }
        return ResponseEntity.ok(currentReserve);
    }

    @ExceptionHandler(EntityException.class)
    public ResponseEntity<String> handleNotFoundedEntity(EntityException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}