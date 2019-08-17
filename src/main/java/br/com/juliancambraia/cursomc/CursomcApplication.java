package br.com.juliancambraia.cursomc;

import br.com.juliancambraia.cursomc.domain.Categoria;
import br.com.juliancambraia.cursomc.domain.Cidade;
import br.com.juliancambraia.cursomc.domain.Cliente;
import br.com.juliancambraia.cursomc.domain.Endereco;
import br.com.juliancambraia.cursomc.domain.Estado;
import br.com.juliancambraia.cursomc.domain.ItemPedido;
import br.com.juliancambraia.cursomc.domain.Pagamento;
import br.com.juliancambraia.cursomc.domain.PagamentoComBoleto;
import br.com.juliancambraia.cursomc.domain.PagamentoComCartao;
import br.com.juliancambraia.cursomc.domain.Pedido;
import br.com.juliancambraia.cursomc.domain.Produto;
import br.com.juliancambraia.cursomc.domain.enums.EstadoPagamento;
import br.com.juliancambraia.cursomc.domain.enums.TipoClienteEnum;
import br.com.juliancambraia.cursomc.repositories.CategoriaRepository;
import br.com.juliancambraia.cursomc.repositories.CidadeRepository;
import br.com.juliancambraia.cursomc.repositories.ClienteRepository;
import br.com.juliancambraia.cursomc.repositories.EnderecoRepository;
import br.com.juliancambraia.cursomc.repositories.EstadoRepository;
import br.com.juliancambraia.cursomc.repositories.ItemPedidoRepository;
import br.com.juliancambraia.cursomc.repositories.PagamentoRepository;
import br.com.juliancambraia.cursomc.repositories.PedidoRepository;
import br.com.juliancambraia.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    public static final String PATTERN = "dd/MM/yyyy HH:mm";
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

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

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        this.produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado("Minas Gerais");
        Estado est2 = new Estado("São Paulo");

        Cidade c1 = new Cidade("Uberlândia", est1);
        Cidade c2 = new Cidade("São Paulo", est2);
        Cidade c3 = new Cidade("Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        this.estadoRepository.saveAll(Arrays.asList(est1, est2));
        this.cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912371", TipoClienteEnum.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("27363323", "938388393"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "100", "Sala 800", "Centro", "38777012", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        this.clienteRepository.saveAll(Arrays.asList(cli1));
        this.enderecoRepository.saveAll(Arrays.asList(e1, e2));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(PATTERN);

        LocalDateTime dt1 = LocalDateTime.parse("30/09/2017 10:32", dtf);
        Pedido ped1 = new Pedido(dt1, cli1, e1);

        LocalDateTime dt2 = LocalDateTime.parse("10/10/2017 19:35", dtf);
        Pedido ped2 = new Pedido(dt2, cli1, e2);

        Pagamento pagto1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        LocalDateTime dtv = LocalDateTime.parse("20/10/2017 23:59", dtf);
        LocalDateTime dtp = null;
        Pagamento pagto2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2, dtv, dtp);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        this.pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        this.pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 2000.00, 0.00, 1);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 80.00, 0.00, 2);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 800.00, 100.00, 1);
        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll((Arrays.asList(ip3)));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        this.itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
    }
}
