package com.rlonghi.curso.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rlonghi.curso.entidades.Usuario;
import com.rlonghi.curso.repositorios.RepositorioUsuario;
import com.rlonghi.curso.servicos.excecoes.ExcecaoBancoDeDados;
import com.rlonghi.curso.servicos.excecoes.ExcecaoRecursoNaoEncontrado;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;

	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}

	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ExcecaoRecursoNaoEncontrado(id));
	}

	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}

	public void deletar(Long id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ExcecaoRecursoNaoEncontrado(id);
		} catch (DataIntegrityViolationException e) {
			throw new ExcecaoBancoDeDados(e.getMessage());
		}
	}

	public Usuario atualizar(Long id, Usuario obj) {
		try {
			Usuario entidade = repositorio.getOne(id);
			atualizarDados(entidade, obj);
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ExcecaoRecursoNaoEncontrado(id);
		}
	}

	private void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
}
