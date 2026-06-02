package com.sistema.backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.backend.dto.RelatorioEspecialidadeDTO;
import com.sistema.backend.service.RelatorioDiarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioController {

	private final RelatorioDiarioService service;

	@GetMapping("/periodo")
	public List<RelatorioEspecialidadeDTO> buscarPorPeriodo(

			@RequestParam LocalDate dataInicio,

			@RequestParam LocalDate dataFim) {

		return service.buscarPorPeriodo(dataInicio, dataFim);
	}
}