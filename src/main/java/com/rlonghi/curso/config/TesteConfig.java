package com.rlonghi.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rlonghi.curso.entidades.Categoria;
import com.rlonghi.curso.entidades.Pedido;
import com.rlonghi.curso.entidades.Produto;
import com.rlonghi.curso.entidades.Usuario;
import com.rlonghi.curso.entidades.enums.StatusPedido;
import com.rlonghi.curso.repositorios.RepositorioCategoria;
import com.rlonghi.curso.repositorios.RepositorioPedido;
import com.rlonghi.curso.repositorios.RepositorioProduto;
import com.rlonghi.curso.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	private RepositorioPedido respositorioPedido;

	@Autowired
	private RepositorioCategoria repositorioCategoria;

	@Autowired
	private RepositorioProduto repositorioProduto;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Electronicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");

		repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));

		Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		repositorioProduto.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.PAGAMENTO_PENDENTE, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.PAGAMENTO_PENDENTE, u1);

		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		respositorioPedido.saveAll(Arrays.asList(p1, p2, p3));
	}

}
