package br.com.juliancambraia.cursomc.repositories;

import br.com.juliancambraia.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
