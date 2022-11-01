package br.com.fiap.checkpoint3.pedido.dto;

import br.com.fiap.checkpoint3.pedido.Pedido;

public class PedidoCreateDto {
	private String dataPedido;
	private String dataCadastro;
	private String valorTotal;

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pedido toEntity() {
		Pedido pedido = new Pedido();
		pedido.setDataPedido(this.dataPedido);
		pedido.setDataCadastro(this.dataCadastro);
		pedido.setValorTotal(this.valorTotal);
		return pedido;
	}
}
