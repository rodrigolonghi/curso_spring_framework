package com.rlonghi.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rlonghi.curso.entidades.Pedido;
import com.rlonghi.curso.repositorios.RepositorioPedido;

@Service
public class ServicoPedido {

	@Autowired
	private RepositorioPedido repositorio;

	public List<Pedido> buscarTodos() {
		return repositorio.findAll();
	}

	public Pedido buscarPorId(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
}
