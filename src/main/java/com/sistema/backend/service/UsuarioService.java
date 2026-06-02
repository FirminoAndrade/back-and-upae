package com.sistema.backend.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.backend.entity.Usuario;
import com.sistema.backend.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository repository;

	private final PasswordEncoder encoder;

	public List<Usuario> listar() {

		return repository.findAll();
	}

	public Usuario salvar(Usuario usuario) {

		usuario.setSenha(encoder.encode(usuario.getSenha()));

		return repository.save(usuario);
	}

	public Usuario atualizar(Long id, Usuario usuario) {

		Usuario existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		existente.setNome(usuario.getNome());
		
		existente.setLogin(usuario.getLogin());
		
		existente.setPerfil(usuario.getPerfil());
		
		existente.setAtivo(usuario.getAtivo());

		if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
			existente.setSenha(encoder.encode(usuario.getSenha()));
		}

		return repository.save(existente);
	}

	public void deletar(Long id) {

		Usuario existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		repository.delete(existente);
	}
}
