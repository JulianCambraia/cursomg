package br.com.juliancambraia.cursomc.resources;

import br.com.juliancambraia.cursomc.domain.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @GetMapping()
    public List<Categoria> listar() {
        Categoria categoria = new Categoria(1L, "Informática");
        Categoria categoria1 = new Categoria(2L, "Escritório");
        List<Categoria> lista = new ArrayList<>();
        lista.add(categoria);
        lista.add(categoria1);

        return lista;
    }
}
