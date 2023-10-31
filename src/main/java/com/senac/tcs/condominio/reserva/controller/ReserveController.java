package com.senac.tcs.condominio.reserva.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.tcs.condominio.reserva.model.entities.Reserve;
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
    public ResponseEntity register() {
        return ResponseEntity.ok().build();
    }
}