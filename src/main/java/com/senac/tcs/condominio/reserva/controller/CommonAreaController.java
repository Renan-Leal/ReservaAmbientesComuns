package com.senac.tcs.condominio.reserva.controller;

import com.senac.tcs.condominio.reserva.model.service.CommonAreaService;
import com.senac.tcs.condominio.reserva.model.entities.CommonArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
@RequestMapping("/commonArea")
public class CommonAreaController {
    
    @Autowired
    private CommonAreaService service;

    @GetMapping("/listAll")
    public List<CommonArea> listAll() {
        return service.listAll();
    }

    @PostMapping("/register")
    public ResponseEntity register() {
        return ResponseEntity.ok().build();
    }
}
