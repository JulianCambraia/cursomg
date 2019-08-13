package br.com.juliancambraia.cursomc.repositories;

import br.com.juliancambraia.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
