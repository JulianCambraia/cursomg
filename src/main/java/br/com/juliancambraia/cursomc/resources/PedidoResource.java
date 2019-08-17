package br.com.juliancambraia.cursomc.resources;

import br.com.juliancambraia.cursomc.domain.Pedido;
import br.com.juliancambraia.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> find(@PathVariable Long id) {

        Pedido pedido = this.pedidoService.buscar(id);

        return ResponseEntity.ok().body(pedido);
    }
}
