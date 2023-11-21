package com.senac.tcs.condominio.reserva.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.tcs.condominio.reserva.model.dto.CondomDTO;
import com.senac.tcs.condominio.reserva.model.entities.Condom;
import com.senac.tcs.condominio.reserva.model.exception.EntityException;
import com.senac.tcs.condominio.reserva.model.service.CondomService;
import com.senac.tcs.condominio.reserva.model.service.TokenService;

import ch.qos.logback.core.subst.Token;

@RestController
@RequestMapping("/condom")
public class CondomController {

    @Autowired
    private CondomService service;

    @Autowired
    TokenService tokenService;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Condom condom) {
        try {
            var condomPassword = new UsernamePasswordAuthenticationToken(condom.getName(), condom.getPassword());
            // Condom condom = new Condom(condomDTO.name(), condomDTO.password());
            var authenticate = this.authenticationManager.authenticate(condomPassword);
            var token = tokenService.generatetoken((Condom) authenticate.getPrincipal());
            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas " + e.getMessage());
        }
    }

    @GetMapping("/listAll")
    public List<Condom> listAll() {
        return service.listAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CondomDTO condomDTO) {
        // if (condomDTO.name().isBlank() || condomDTO.birth() == null || condomDTO.cpf().isBlank()) {
        //     throw new EntityException("All fields are mandatory");
        // }
        String encryptedPassword = new BCryptPasswordEncoder().encode(condomDTO.password());
        Condom condom = new Condom(condomDTO.name(), condomDTO.birth(), condomDTO.cpf(), encryptedPassword, condomDTO.userRole());
        service.register(condom);
        return ResponseEntity.ok().build();
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
