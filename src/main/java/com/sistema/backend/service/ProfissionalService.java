package com.sistema.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.backend.entity.Profissional;
import com.sistema.backend.repository.ProfissionalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfissionalService {

	private final ProfissionalRepository repository;

	public List<Profissional> listar() {
		return repository.findAll();
	}

	public Profissional salvar(Profissional obj) {
		return repository.save(obj);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}
}