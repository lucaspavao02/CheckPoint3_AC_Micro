package br.com.fiap.checkpoint3.pedido;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.fiap.checkpoint3.pedido.Pedido;
import br.com.fiap.checkpoint3.pedido.PedidoRepository;
import br.com.fiap.checkpoint3.pedido.PedidoService;

public class PedidoServiceMockTest {
	@Mock
	private PedidoRepository pedidoRepository;

	@InjectMocks
	private PedidoService pedidoService;

	Pageable pageable = Pageable.unpaged();

	@BeforeAll
	public static void init() {
		System.out.println("@BeforeAll");
	}

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		System.out.println("@BeforeEach");
	}

	@Test
	void givenListaSemPedidos_whenListarTodos_thenReturnListaVazia() {
		// Given
		List<Pedido> pedidos = new ArrayList<>();
		Mockito.when(pedidoRepository.findAll()).thenReturn(pedidos);

		// When
		Page<Pedido> result = pedidoService.findAll(pageable);

		// Then
		Assertions.assertEquals(0, result.getTotalElements());

	}

	@Test
	void givenListaComPedidos_whenListarTodos_thenReturnAListaEPositiva() {
		// Given
		List<Pedido> pedidos = new ArrayList<>();
		pedidos.add(new Pedido());

		Mockito.when(pedidoRepository.findAll()).thenReturn(pedidos);

		// When
		Page<Pedido> result = pedidoService.findAll(pageable);

		// Then
		Assertions.assertTrue(result.getTotalElements() > 0);
	}
}
