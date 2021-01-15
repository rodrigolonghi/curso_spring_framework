package com.rlonghi.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rlonghi.curso.entidades.Produto;
import com.rlonghi.curso.repositorios.RepositorioProduto;

@Service
public class ServicoProduto {

	@Autowired
	private RepositorioProduto repositorio;

	public List<Produto> buscarTodos() {
		return repositorio.findAll();
	}

	public Produto buscarPorId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
}
