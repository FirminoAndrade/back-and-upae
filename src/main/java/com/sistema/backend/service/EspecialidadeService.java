package com.sistema.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.backend.entity.Especialidade;
import com.sistema.backend.repository.EspecialidadeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EspecialidadeService {

	private final EspecialidadeRepository repository;

	public List<Especialidade> listar() {

		return repository.findAll();
	}

	public Especialidade salvar(Especialidade especialidade) {

		return repository.save(especialidade);
	}
	
	public void remover(Long id) {

	    repository.deleteById(id);
	}
}
