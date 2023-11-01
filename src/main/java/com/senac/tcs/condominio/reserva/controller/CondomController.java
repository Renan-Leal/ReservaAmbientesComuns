package com.senac.tcs.condominio.reserva.controller;

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

import com.senac.tcs.condominio.reserva.model.entities.Condom;
import com.senac.tcs.condominio.reserva.model.service.CondomService;
import com.senac.tcs.condominio.reserva.util.EntityException;

@RestController
@RequestMapping("/condom")
public class CondomController {

    @Autowired
    private CondomService service;
    
    @GetMapping("/listAll")
    public List<Condom> listAll() {
        return service.listAll();
    }

    @PostMapping("/register")
    public Condom register(@RequestBody Condom condom) {
        Condom registeredCondom = service.register(condom);
        return registeredCondom;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Condom deletedCondom = service.findById(id);
        if (deletedCondom != null) {
            service.deleteById(id);
        }
        return ResponseEntity.ok(deletedCondom);
    }

    @GetMapping("/{id}")
    public Condom listById(@PathVariable Long id) {
        Condom condom = service.findById(id);
        return condom;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Condom condom) {
        Condom currentCondom = service.findById(id);
        if (currentCondom.getId() != null) {
            condom.setId(id);
            currentCondom = service.register(condom);
        }
        return ResponseEntity.ok(currentCondom);
    }

    @ExceptionHandler(EntityException.class)
    public ResponseEntity<String> handleNotFoundedEntity(EntityException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
