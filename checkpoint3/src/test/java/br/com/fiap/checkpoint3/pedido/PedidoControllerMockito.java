package br.com.fiap.checkpoint3.pedido;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import br.com.fiap.checkpoint3.pedido.Pedido;
import br.com.fiap.checkpoint3.pedido.PedidoController;
import br.com.fiap.checkpoint3.pedido.PedidoService;
import br.com.fiap.checkpoint3.pedido.dto.PedidoSearchDto;

public class PedidoControllerMockito {

	@Mock
	private PedidoService pedidoService;

	@InjectMocks
	private PedidoController controller;

	Pageable pageable = Pageable.unpaged();

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		System.out.println("@BeforeEach");
	}

	@Test
	void givenSemPedidos_whenListaTodos_then_Return204() {
		// given
		Page<Pedido> pedidos = Page.empty();

		Mockito.when(pedidoService.findAll(pageable)).thenReturn(pedidos);

		// when
		ResponseEntity<Page<PedidoSearchDto>> response = controller.listAll(pageable);

		// then
		Assertions.assertEquals(204, response.getStatusCodeValue());
	}

	@Test
	void givenComPedidos_whenListaTodos_then_Return200() {
		// given
		Page<Pedido> pedidos = Page.empty();
		// pedidos.add(new Pedido());

		Mockito.when(pedidoService.findAll(pageable)).thenReturn(pedidos);

		// when
		ResponseEntity<Page<PedidoSearchDto>> response = controller.listAll(pageable);

		// then
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
}
