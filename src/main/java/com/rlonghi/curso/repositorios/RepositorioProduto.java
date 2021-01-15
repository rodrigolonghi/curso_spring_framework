package com.rlonghi.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rlonghi.curso.entidades.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long>{
	
}
