package com.senac.tcs.condominio.reserva.controller;

import com.senac.tcs.condominio.reserva.model.service.CommonAreaService;
import com.senac.tcs.condominio.reserva.util.EntityException;
import com.senac.tcs.condominio.reserva.model.entities.CommonArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import javax.swing.text.html.parser.Entity;

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
    public CommonArea register(@RequestBody CommonArea commonArea) {
        CommonArea registeredCommonArea = service.register(commonArea);
        return registeredCommonArea;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        CommonArea deletedCommonArea = service.findById(id);
        if (deletedCommonArea != null) {
            service.deleteById(id);
        }
        return ResponseEntity.ok(deletedCommonArea);
    }

    @GetMapping("/{id}")
    public CommonArea listById(@PathVariable Long id) {
        CommonArea commonArea = service.findById(id);
        return commonArea;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CommonArea commonArea) {
        CommonArea currentCommonArea = service.findById(id);
        if (currentCommonArea.getId() != null) {
            commonArea.setId(id);
            currentCommonArea = service.register(commonArea);
        }
        return ResponseEntity.ok(currentCommonArea);
    }

    @ExceptionHandler(EntityException.class)
    public ResponseEntity<String> handleNotFoundedEntity(EntityException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
