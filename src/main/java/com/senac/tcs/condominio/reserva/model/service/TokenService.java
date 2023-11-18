package com.senac.tcs.condominio.reserva.model.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.senac.tcs.condominio.reserva.model.entities.Condom;
import com.senac.tcs.condominio.reserva.model.exception.EntityException;

@Service
public class TokenService {
    
    private String secret = "";

    public String generatetoken(Condom condom) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
            .withIssuer("CondomAreaSystem")
            .withSubject(condom.getName())
            .withExpiresAt(getTempExpires())
            .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new EntityException("Failure to generate token");
        }
    }

    private Instant getTempExpires() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.ofHours(-3));
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("CondomAreaSystem")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }
}
