package br.com.juliancambraia.cursomc.resources;

import br.com.juliancambraia.cursomc.domain.Cliente;
import br.com.juliancambraia.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> find(@PathVariable Long id) {
        Cliente cliente = this.clienteService.buscar(id);
        return ResponseEntity.ok().body(cliente);
    }
}
