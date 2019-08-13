package br.com.juliancambraia.cursomc.domain.enums;

public enum TipoClienteEnum {
    PESSOAFISICA(0L, "Pessoa Física"),
    PESSOAJURIDICA(1L, "Pessoa Jurídica");

    private Long codigo;
    private String descricao;

    private TipoClienteEnum(Long codigo, String descricao) {
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
            if (x.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
