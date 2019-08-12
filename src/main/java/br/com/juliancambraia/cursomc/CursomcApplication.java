package br.com.juliancambraia.cursomc;

import br.com.juliancambraia.cursomc.domain.Categoria;
import br.com.juliancambraia.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CursomcApplication(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
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

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
    }
}
