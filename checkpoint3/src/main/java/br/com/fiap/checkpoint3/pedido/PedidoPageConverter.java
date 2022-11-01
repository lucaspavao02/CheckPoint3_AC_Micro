package br.com.fiap.checkpoint3.pedido;

import java.util.function.Function;

import br.com.fiap.checkpoint3.pedido.dto.PedidoSearchDto;

public class PedidoPageConverter 
	implements Function<Pedido, PedidoSearchDto> {
	
	@Override
	public PedidoSearchDto apply(Pedido pedido) {
		return PedidoSearchDto.toDto(pedido);
	}

}
