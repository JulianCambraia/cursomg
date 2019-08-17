package br.com.juliancambraia.cursomc.repositories;

import br.com.juliancambraia.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
