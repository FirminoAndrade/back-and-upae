package com.sistema.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.backend.entity.Agenda;
import com.sistema.backend.service.AgendaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/agenda")
@RequiredArgsConstructor
public class AgendaController {

	private final AgendaService service;

	@GetMapping
	public List<Agenda> listar() {

		return service.listar();
	}

	@GetMapping("/{id}")
	public Agenda buscarPorId(@PathVariable Long id) {

		return service.buscarPorId(id);
	}

	@PostMapping
	public Agenda salvar(@RequestBody Agenda agenda) {

		return service.salvar(agenda);
	}

	@PutMapping("/{id}")
	public Agenda atualizar(@PathVariable Long id, @RequestBody Agenda agenda) {

		return service.atualizar(id, agenda);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {

		service.remover(id);
	}
}
