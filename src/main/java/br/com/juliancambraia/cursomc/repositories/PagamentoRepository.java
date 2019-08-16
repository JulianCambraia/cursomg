package br.com.juliancambraia.cursomc.repositories;

import br.com.juliancambraia.cursomc.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
