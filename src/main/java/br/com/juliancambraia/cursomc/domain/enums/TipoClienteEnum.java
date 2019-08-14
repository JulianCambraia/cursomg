package br.com.juliancambraia.cursomc.domain.enums;

public enum TipoClienteEnum {
    PESSOAFISICA(1L, "Pessoa Física"),
    PESSOAJURIDICA(2L, "Pessoa Jurídica");

    private Long codigo;
    private String descricao;

    TipoClienteEnum(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoClienteEnum toEnum(Long codigo) {
        if (codigo == null) {
            return null;
        }
        for (TipoClienteEnum x : TipoClienteEnum.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
