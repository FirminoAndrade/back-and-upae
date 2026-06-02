package com.sistema.backend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.backend.dto.RelatorioEspecialidadeDTO;
import com.sistema.backend.repository.RelatorioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RelatorioDiarioService {

	private final RelatorioRepository repository;

	public List<RelatorioEspecialidadeDTO> buscarPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {

		return repository.relatorioPorPeriodo(dataInicio, dataFim);
	}
}