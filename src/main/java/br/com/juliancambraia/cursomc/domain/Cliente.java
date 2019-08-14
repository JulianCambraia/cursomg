package br.com.juliancambraia.cursomc.domain;

import br.com.juliancambraia.cursomc.domain.enums.TipoClienteEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String cpfOuCnpj;

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    private Long tipoClienteEnum;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String cpfOuCnpj, TipoClienteEnum tipoCliente) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoClienteEnum = tipoCliente.getCodigo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoClienteEnum getTipoClienteEnum() {
        return TipoClienteEnum.toEnum(tipoClienteEnum);
    }

    public void setTipoClienteEnum(TipoClienteEnum tipoClienteEnum) {
        this.tipoClienteEnum = tipoClienteEnum.getCodigo();
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public void setTipoClienteEnum(Long tipoClienteEnum) {
        this.tipoClienteEnum = tipoClienteEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return getId().equals(cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
