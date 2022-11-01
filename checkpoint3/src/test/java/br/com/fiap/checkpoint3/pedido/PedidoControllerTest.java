package br.com.fiap.checkpoint3.pedido;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import br.com.fiap.checkpoint3.pedido.Pedido;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PedidoControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testQuandoNaoTemPedidoEntaoRetornar204() {
		
		String endpoint = "http://localhost:" + port + "/pedidos";
		// URL url = new URL(endpoint);

		ResponseEntity<Pedido[]> response = restTemplate.getForEntity(endpoint, Pedido[].class);

		Assertions.assertEquals(204, response.getStatusCodeValue());
	}
	
	@Test
	public void testQuandoTemPedidoEntaoRetornar200() {
		
		String endpoint = "http://localhost:" + port + "/pedidos";
		// URL url = new URL(endpoint);

		ResponseEntity<Pedido[]> response = restTemplate.getForEntity(endpoint, Pedido[].class);

		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
}
