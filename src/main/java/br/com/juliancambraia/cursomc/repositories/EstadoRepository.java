package br.com.juliancambraia.cursomc.repositories;

import br.com.juliancambraia.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
