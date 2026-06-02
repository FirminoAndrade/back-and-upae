package com.sistema.backend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.backend.dto.RegistroDiarioDTO;
import com.sistema.backend.dto.RegistroDiarioRequestDTO;
import com.sistema.backend.entity.Especialidade;
import com.sistema.backend.entity.RegistroDiario;
import com.sistema.backend.repository.EspecialidadeRepository;
import com.sistema.backend.repository.RegistroDiarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistroDiarioService {

	private final RegistroDiarioRepository repository;
	private final EspecialidadeRepository especialidadeRepository;

	public List<RegistroDiario> listar() {

		return repository.findAll();
	}

	public RegistroDiario salvar(RegistroDiarioRequestDTO dto) {

		Especialidade especialidade = especialidadeRepository.findById(dto.getEspecialidadeId()).orElseThrow();

		RegistroDiario diaria = RegistroDiario.builder()

				.data(dto.getData())

				.totalAgendados(dto.getTotalAgendados())

				.compareceram(dto.getCompareceram())

				.observacao(dto.getObservacao())

				.interno(dto.getInterno())

				.externo(dto.getExterno())
				
				.interconsulta(dto.getInterconsulta())

				.nomeProfissional(dto.getNomeProfissional())

				.especialidade(especialidade)

				.build();

		return repository.save(diaria);
	}

	public RegistroDiario atualizar(Long id, RegistroDiarioRequestDTO dto) {

		RegistroDiario existente = repository.findById(id).orElseThrow();
		Especialidade especialidade = especialidadeRepository.findById(dto.getEspecialidadeId()).orElseThrow();

		existente.setData(dto.getData());

		existente.setTotalAgendados(dto.getTotalAgendados());

		existente.setCompareceram(dto.getCompareceram());

		existente.setObservacao(dto.getObservacao());

		existente.setExterno(dto.getExterno());

		existente.setInterno(dto.getInterno());
		
		existente.setInterconsulta(dto.getInterconsulta());

		existente.setNomeProfissional(dto.getNomeProfissional());

		existente.setEspecialidade(especialidade);

		return repository.save(existente);
	}

	public List<RegistroDiario> buscarPorPeriodo(LocalDate inicio, LocalDate fim) {

		return repository.findByDataBetween(inicio, fim);
	}

	public RegistroDiarioDTO buscarPorId(Long id) {

		RegistroDiario entity = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Registro não encontrado"));

		RegistroDiarioDTO dto = new RegistroDiarioDTO();

		dto.setId(entity.getId());
		dto.setData(entity.getData());
		dto.setTotalAgendados(entity.getTotalAgendados());
		dto.setCompareceram(entity.getCompareceram());
		dto.setInterno(entity.getInterno());
		dto.setExterno(entity.getExterno());
		dto.setInterconsulta(entity.getInterconsulta());
		dto.setObservacao(entity.getObservacao());
		dto.setNomeProfissional(entity.getNomeProfissional());
		dto.setEspecialidadeId(entity.getEspecialidade().getId());

		return dto;
	}

}
