package br.com.juliancambraia.cursomc.services;

import br.com.juliancambraia.cursomc.domain.Cliente;
import br.com.juliancambraia.cursomc.repositories.ClienteRepository;
import br.com.juliancambraia.cursomc.services.exceptions.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente buscar(Long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundExeption("Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
