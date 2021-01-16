package com.rlonghi.curso.recursos.execoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rlonghi.curso.servicos.excecoes.ExcecaoRecursoNaoEncontrado;

@ControllerAdvice
public class ExecaoManualRecurso {

	@ExceptionHandler(ExcecaoRecursoNaoEncontrado.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(ExcecaoRecursoNaoEncontrado e, HttpServletRequest request) {
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
