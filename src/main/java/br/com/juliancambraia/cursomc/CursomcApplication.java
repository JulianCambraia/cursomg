package br.com.juliancambraia.cursomc;

import br.com.juliancambraia.cursomc.domain.Categoria;
import br.com.juliancambraia.cursomc.domain.Produto;
import br.com.juliancambraia.cursomc.repositories.CategoriaRepository;
import br.com.juliancambraia.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    private ProdutoRepository produtoRepository;

    public CursomcApplication(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    /**
     * Implementação provisória pois estamos usando banco de dados em memória H2 e simulando as inserções
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().add(p1);
        cat1.getProdutos().add(p2);
        cat1.getProdutos().add(p3);

        cat2.getProdutos().add(p1);

        p1.getCategorias().add(cat1);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat2);
        p3.getCategorias().add(cat1);

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        this.produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
