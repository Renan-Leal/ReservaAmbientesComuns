package com.senac.tcs.condominio.reserva.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.senac.tcs.condominio.reserva.model.repository.CondomRepository;
import com.senac.tcs.condominio.reserva.model.service.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.var;

@Component
public class SecurityFilter extends OncePerRequestFilter{
    @Autowired
    TokenService tokenService;

    @Autowired
    CondomRepository condomRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null) {
            String condomName = tokenService.validateToken(token);
            UserDetails user = condomRepository.findByName(condomName);
            var autorizathion = new UsernamePasswordAuthenticationToken(null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autorizathion);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authenticateHeader = request.getHeader("Authorization");
        if (authenticateHeader == null) {
            return null;
        }
        return authenticateHeader.replace("Bearer", "");
    }
}
