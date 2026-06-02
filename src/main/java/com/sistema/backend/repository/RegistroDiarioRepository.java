package com.sistema.backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.backend.entity.RegistroDiario;

public interface RegistroDiarioRepository extends JpaRepository<RegistroDiario, Long> {

	List<RegistroDiario> findByDataBetween(LocalDate inicio, LocalDate fim);

}