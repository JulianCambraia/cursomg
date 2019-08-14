package br.com.juliancambraia.cursomc.services;

import br.com.juliancambraia.cursomc.domain.Categoria;
import br.com.juliancambraia.cursomc.repositories.CategoriaRepository;
import br.com.juliancambraia.cursomc.services.exceptions.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscar(Long id) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundExeption("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
