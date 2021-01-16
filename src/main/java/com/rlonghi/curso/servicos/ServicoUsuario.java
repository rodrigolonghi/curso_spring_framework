package com.rlonghi.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rlonghi.curso.entidades.Usuario;
import com.rlonghi.curso.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;

	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}

	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	
	public Usuario atualizar(Long id, Usuario obj) {
		Usuario entidade = repositorio.getOne(id);
		atualizarDados(entidade, obj);
		return repositorio.save(entidade);
	}

	private void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
}
