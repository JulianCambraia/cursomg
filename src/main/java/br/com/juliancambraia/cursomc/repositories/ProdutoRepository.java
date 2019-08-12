package br.com.juliancambraia.cursomc.repositories;

import br.com.juliancambraia.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
