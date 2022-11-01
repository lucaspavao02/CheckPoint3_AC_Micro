package br.com.fiap.checkpoint3.pedido.dto;

import br.com.fiap.checkpoint3.pedido.Pedido;

public class PedidoUpdateDto {
	private Long id;
	private String dataPedido;
	private String dataCadastro;
	private String valorTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

		pedido.setId(this.id);
		pedido.setDataPedido(this.dataPedido);
		pedido.setDataCadastro(this.dataCadastro);
		pedido.setValorTotal(this.valorTotal);

		return pedido;
	}

}
