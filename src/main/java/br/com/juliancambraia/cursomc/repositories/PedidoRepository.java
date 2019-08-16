package br.com.juliancambraia.cursomc.repositories;

import br.com.juliancambraia.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
