package br.com.fiap.checkpoint3.pedido;

public class PedidoSearchDto {
	private Long id;
	private String dataPedido;
	private String dataCadastro;
	private String valorTotal;

	public PedidoSearchDto(Long id, String dataPedido, String dataCadastro, String valorTotal) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataCadastro = dataCadastro;
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public String getDataPedido() {
		return dataPedido;
	}
	
	public String getDataCadastro() {
		return dataCadastro;
	}
	
	public String getValorTotal() {
		return valorTotal;
	}
	
	public static PedidoSearchDto toDto(Pedido pedido) {
		return new PedidoSearchDto(pedido.getId(), pedido.getDataPedido(), pedido.getDataCadastro(), pedido.getValorTotal());
	}

}
