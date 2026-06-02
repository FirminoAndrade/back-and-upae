package com.sistema.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.backend.entity.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}