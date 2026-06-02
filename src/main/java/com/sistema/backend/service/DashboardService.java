package com.sistema.backend.service;

import org.springframework.stereotype.Service;

import com.sistema.backend.dto.DashboardDTO;
import com.sistema.backend.repository.EspecialidadeRepository;
import com.sistema.backend.repository.RegistroDiarioRepository;
import com.sistema.backend.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardService {

	private final RegistroDiarioRepository diariaRepository;

	private final EspecialidadeRepository especialidadeRepository;

	private final UsuarioRepository usuarioRepository;

	public DashboardDTO obterTotais() {

		return DashboardDTO.builder()

				.totalDiarias(diariaRepository.count())

				.totalEspecialidades(especialidadeRepository.count())

				.totalUsuarios(usuarioRepository.count())

				.build();
	}
}
