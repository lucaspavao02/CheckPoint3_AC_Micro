package br.com.fiap.checkpoint3.pedido;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository 
	extends PagingAndSortingRepository<Pedido, Long> {

}
