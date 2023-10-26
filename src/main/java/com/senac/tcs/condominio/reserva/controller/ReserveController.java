package com.senac.tcs.condominio.reserva.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.tcs.condominio.reserva.model.entities.CommonArea;
import com.senac.tcs.condominio.reserva.model.entities.Reserve;
import com.senac.tcs.condominio.reserva.model.service.CondomService;
import com.senac.tcs.condominio.reserva.model.service.ReserveService;

@RestController
@RequestMapping("/reserve")
public class ReserveController {
    
       private ReserveService service;
    
    @GetMapping("/listAll")
    public List<Reserve> listAllReserves() {
        return new ArrayList<>();
    }

    @PostMapping("/register")
    public ResponseEntity registerReserve() {
        return ResponseEntity.ok().build();
    }

}