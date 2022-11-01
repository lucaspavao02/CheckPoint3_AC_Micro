package br.com.fiap.checkpoint3.pedido;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedioRepository;

	public Page<Pedido> findAll(Pageable pageable) {
		return pedioRepository.findAll(pageable);
	}

	public Pedido findById(Long id) {
		Optional<Pedido> opt = pedioRepository.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public void delete(Long id) {
		pedioRepository.deleteById(id);
	}

	public Pedido save(Pedido pedido) {
		return pedioRepository.save(pedido);
	}
}
