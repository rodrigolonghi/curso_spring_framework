package com.rlonghi.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rlonghi.curso.entidades.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long>{
	
}
