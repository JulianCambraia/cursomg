package br.com.juliancambraia.cursomc.services;

import br.com.juliancambraia.cursomc.domain.Pedido;
import br.com.juliancambraia.cursomc.repositories.PedidoRepository;
import br.com.juliancambraia.cursomc.services.exceptions.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscar(Long id) {

        Optional<Pedido> pedido = this.pedidoRepository.findById(id);

        return pedido.orElseThrow(() -> new ObjectNotFoundExeption("Objeto não encontrado id: " + id + " Tipo: " + Pedido.class.getName()));

    }

}
