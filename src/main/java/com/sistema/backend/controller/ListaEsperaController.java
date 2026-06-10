package com.sistema.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.backend.dto.ListaEsperaDTO;
import com.sistema.backend.entity.ListaEspera;
import com.sistema.backend.service.ListaEsperaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lista-espera")
@RequiredArgsConstructor
public class ListaEsperaController {

	private final ListaEsperaService service;

	@GetMapping
	public List<ListaEspera> listar(

			@RequestParam(required = false) String especialidade,

			@RequestParam(required = false) String termo) {

		return service.listar(especialidade, termo);
	}

	@PostMapping
	public ListaEspera salvar(@RequestBody ListaEsperaDTO dto) {

		return service.salvar(dto);
	}

	@PutMapping("/{id}")
	public ListaEspera atualizar(

			@PathVariable Long id,

			@RequestBody ListaEsperaDTO dto) {

		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {

		service.remover(id);
	}

}
