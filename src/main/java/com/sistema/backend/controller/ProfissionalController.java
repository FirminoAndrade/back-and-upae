package com.sistema.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.backend.entity.Profissional;
import com.sistema.backend.service.ProfissionalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profissionais")
@RequiredArgsConstructor
public class ProfissionalController {

	private final ProfissionalService service;

	@GetMapping
	public ResponseEntity<List<Profissional>> listar() {
		return ResponseEntity.ok(service.listar());
	}

	@PostMapping
	public ResponseEntity<Profissional> salvar(@RequestBody Profissional obj) {

		return ResponseEntity.ok(service.salvar(obj));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		service.deletar(id);

		return ResponseEntity.noContent().build();
	}
}
