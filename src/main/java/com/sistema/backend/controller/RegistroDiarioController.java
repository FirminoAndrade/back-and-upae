package com.sistema.backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.backend.dto.RegistroDiarioDTO;
import com.sistema.backend.dto.RegistroDiarioRequestDTO;
import com.sistema.backend.entity.RegistroDiario;
import com.sistema.backend.service.RegistroDiarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/diarias")
@RequiredArgsConstructor
public class RegistroDiarioController {

	private final RegistroDiarioService service;

	@GetMapping
	public List<RegistroDiarioDTO> listar() {

		return service.listar().stream().map(this::converterDTO).toList();
	}

	@PostMapping
	public RegistroDiario salvar(@RequestBody RegistroDiarioRequestDTO dto) {

		return service.salvar(dto);
	}

	@PutMapping("/{id}")
	public RegistroDiario atualizar(

			@PathVariable Long id,

			@RequestBody RegistroDiarioRequestDTO dto) {

		return service.atualizar(id, dto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RegistroDiarioDTO> buscarPorId(@PathVariable Long id) {
	    return ResponseEntity.ok(service.buscarPorId(id));
	}
	
	@GetMapping("/periodo")
	public List<RegistroDiarioDTO> buscarPorPeriodo(

			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,

			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {

		return service.buscarPorPeriodo(inicio, fim).stream().map(this::converterDTO).toList();
	}

	private RegistroDiarioDTO converterDTO(RegistroDiario diaria) {

		return RegistroDiarioDTO.builder().id(diaria.getId()).data(diaria.getData())
				.totalAgendados(diaria.getTotalAgendados()).compareceram(diaria.getCompareceram())
				.faltaram(diaria.getFaltaram()).observacao(diaria.getObservacao()).interno(diaria.getInterno()).interconsulta(diaria.getInterconsulta())
				.externo(diaria.getExterno()).especialidadeId(diaria.getEspecialidade().getId())
				.especialidadeNome(diaria.getEspecialidade().getNome()).nomeProfissional(diaria.getNomeProfissional()).build();
	}

}