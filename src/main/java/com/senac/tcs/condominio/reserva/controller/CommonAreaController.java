package com.senac.tcs.condominio.reserva.controller;

import com.senac.tcs.condominio.reserva.model.service.CommonAreaService;
import com.senac.tcs.condominio.reserva.model.entities.CommonArea;
import com.senac.tcs.condominio.reserva.model.service.CommonAreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/commonArea")
public class CommonAreaController {

    private CommonAreaService service;

    @GetMapping("/listAll")
    public List<CommonArea> listAllCommonAreas() {
        return new ArrayList<>();
    }

    @PostMapping("/register")
    public ResponseEntity registerCommonArea() {
        return ResponseEntity.ok().build();
    }
}
