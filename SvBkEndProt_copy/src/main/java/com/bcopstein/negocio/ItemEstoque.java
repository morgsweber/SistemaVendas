package com.bcopstein.negocio;

import javax.persistence.*;

@Entity
public class ItemEstoque {

    @Id
    private Long id;

    private Integer quantidadeDisponivel;

    @OneToOne
    @MapsId
    @JoinColumn(name = "codigo_produto")
    private Produto produto;

    protected ItemEstoque() {}

    public Integer getQuantidadeDisponivel() { return quantidadeDisponivel; }
}
