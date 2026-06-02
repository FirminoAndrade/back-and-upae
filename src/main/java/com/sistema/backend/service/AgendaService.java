package com.sistema.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.backend.entity.Agenda;
import com.sistema.backend.repository.AgendaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendaService {

	private final AgendaRepository repository;

	public List<Agenda> listar() {

		return repository.findAll();
	}

	public Agenda salvar(Agenda agenda) {

		return repository.save(agenda);
	}

	public Agenda atualizar(Long id, Agenda agenda) {

		Agenda existente = repository.findById(id).orElseThrow();

		existente.setData(agenda.getData());

		existente.setEspecialidade(agenda.getEspecialidade());

		existente.setProfissional(agenda.getProfissional());
		
		existente.setTurno(agenda.getTurno());

		existente.setAgendados(agenda.getAgendados());

		existente.setConfirmado(agenda.getConfirmado());

		return repository.save(existente);
	}

	public void remover(Long id) {

		repository.deleteById(id);
	}

	public Agenda buscarPorId(Long id) {

		return repository.findById(id).orElseThrow();
	}
}