package com.bcopstein.negocio;

public class ItemVenda {
    private Integer quantidade;
    private Integer precoUnitVenda;
    private Long imposto;
    private Produto produto;

    public ItemVenda(Integer quantidade, Integer precoUnitVenda, Long imposto) {
        this.quantidade = quantidade;
        this.precoUnitVenda = precoUnitVenda;
        this.imposto = imposto;
    }



    public Integer getQuantidade() { return quantidade; }

    public Integer getPrecoUnitVenda() { return precoUnitVenda; }

    public Long getImposto() { return imposto; }
}
