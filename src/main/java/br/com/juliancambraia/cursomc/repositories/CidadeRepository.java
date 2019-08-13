package br.com.juliancambraia.cursomc.repositories;

import br.com.juliancambraia.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
