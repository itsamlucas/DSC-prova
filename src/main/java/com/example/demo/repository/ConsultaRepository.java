package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.consulta.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
