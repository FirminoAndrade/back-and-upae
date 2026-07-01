package com.sistema.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.backend.dto.ListaEsperaDTO;
import com.sistema.backend.entity.ListaEspera;
import com.sistema.backend.repository.ListaEsperaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListaEsperaService {

	private final ListaEsperaRepository repository;

	public List<ListaEspera> listar(String especialidade, String termo) {

		return repository.pesquisar(especialidade, termo);
	}

	public ListaEspera salvar(ListaEsperaDTO dto) {

		ListaEspera item = new ListaEspera();

		item.setNome(dto.getNome());
		item.setProntuario(dto.getProntuario());
		item.setTelefone(dto.getTelefone());
		item.setDataNascimento(dto.getDataNascimento());
		item.setEspecialidade(dto.getEspecialidade());
		item.setConfirmado(dto.getConfirmado());
		item.setDataSolicitada(dto.getDataSolicitada());
		item.setNomeMedico(dto.getNomeMedico());

		return repository.save(item);
	}

	public ListaEspera atualizar(Long id, ListaEsperaDTO dto) {

		ListaEspera item = repository.findById(id).orElseThrow();

		item.setNome(dto.getNome());
		item.setProntuario(dto.getProntuario());
		item.setTelefone(dto.getTelefone());
        item.setDataNascimento(dto.getDataNascimento());
        item.setEspecialidade(dto.getEspecialidade());
        item.setConfirmado(dto.getConfirmado());
        item.setDataSolicitada(dto.getDataSolicitada());
        item.setNomeMedico(dto.getNomeMedico());

		return repository.save(item);
	}

	public void remover(Long id) {

		repository.deleteById(id);
	}
}
