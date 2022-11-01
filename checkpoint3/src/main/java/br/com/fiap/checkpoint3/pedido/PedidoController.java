package br.com.fiap.checkpoint3.pedido;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint3.pedido.dto.PedidoCreateDto;
import br.com.fiap.checkpoint3.pedido.dto.PedidoSearchDto;
import br.com.fiap.checkpoint3.pedido.dto.PedidoUpdateDto;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<Page<PedidoSearchDto>> listAll(Pageable pageable) {
		Page<Pedido> pedidos = pedidoService.findAll(pageable);

		if (pedidos.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		Page<PedidoSearchDto> dtos = 
				pedidos.map(new PedidoPageConverter());

		return new ResponseEntity<Page<PedidoSearchDto>>(dtos, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody PedidoCreateDto pedido) {

		pedidoService.save(pedido.toEntity());

		return new ResponseEntity<String>("pedido inserido", HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody PedidoUpdateDto pedido) {

		if (pedidoService.findById(pedido.getId()) == null) {

			return new ResponseEntity<String>(String.format("pedido inexistente %d", pedido.getId()),
					HttpStatus.NOT_FOUND);
		}

		pedidoService.save(pedido.toEntity());

		return new ResponseEntity<String>("pedido alterado", HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		if (pedidoService.findById(id) == null) {
			return new ResponseEntity<String>(String.format("pedido inexistente %d", id), HttpStatus.NOT_FOUND);
		}

		pedidoService.delete(id);
		return new ResponseEntity<String>("pedido excluido", HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<PedidoSearchDto> findById(@PathVariable Long id) {
		Pedido pedido = pedidoService.findById(id);

		if (pedido == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		PedidoSearchDto dto = PedidoSearchDto.toDto(pedido);

		return new ResponseEntity<PedidoSearchDto>(dto, HttpStatus.OK);
	}
}
