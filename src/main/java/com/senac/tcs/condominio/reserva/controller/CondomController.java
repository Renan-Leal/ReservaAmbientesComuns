package com.senac.tcs.condominio.reserva.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.tcs.condominio.reserva.model.entities.Condom;
import com.senac.tcs.condominio.reserva.model.service.CondomService;

@RestController
@RequestMapping("/condom")
public class CondomController {

    private CondomService service;
    
    @GetMapping("/listAll")
    public List<Condom> listAllCondoms() {
        return new ArrayList<>();
    }

    @PostMapping("/register")
    public ResponseEntity registerCondom() {
        return ResponseEntity.ok().build();
    }
}
