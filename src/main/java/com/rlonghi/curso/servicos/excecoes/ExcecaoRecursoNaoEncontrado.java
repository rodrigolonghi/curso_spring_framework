package com.rlonghi.curso.servicos.excecoes;

public class ExcecaoRecursoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcecaoRecursoNaoEncontrado(Object id) {
		super("Recurso não encontrado. Id " + id);
	}
}
