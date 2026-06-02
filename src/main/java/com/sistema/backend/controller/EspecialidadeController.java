package com.sistema.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.backend.entity.Especialidade;
import com.sistema.backend.service.EspecialidadeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadeController {

	private final EspecialidadeService service;

	@GetMapping
	public List<Especialidade> listar() {

		return service.listar();
	}

	@PostMapping
	public Especialidade salvar(@RequestBody Especialidade especialidade) {

		return service.salvar(especialidade);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {

		service.remover(id);
	}
}
