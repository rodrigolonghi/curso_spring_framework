package com.rlonghi.curso.entidades.enums;

public enum StatusPedido {
	
	PAGAMENTO_PENDENTE(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusPedido valorDe(int codigo) {
		for(StatusPedido valor : StatusPedido.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Código de status invalido");
	}
}
