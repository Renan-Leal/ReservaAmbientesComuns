package com.senac.tcs.condominio.reserva.model.entities;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Condom")
@Table(name = "Condom")

public class Condom implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 250)
    private String name;
    @Column(nullable = true)
    private LocalDate birth;
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String password;
    private UserRole role;
    
    public Condom(String name, LocalDate birth, String cpf, String password, UserRole role) {
        this.name = name;
        this.birth = birth;
        this.cpf = cpf;
        this.password = password;
        this.role = role;
    }

    public Condom (String name, String password) {
        this.name = name;
        this.password = password;
    }
    // public Condom() {
    // }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));

        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
        }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
