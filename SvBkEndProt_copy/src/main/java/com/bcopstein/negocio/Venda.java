package com.bcopstein.negocio;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Venda {
    @Id
    private Long numero;
    private LocalDate data;
    private List<ItemVenda> itens = new LinkedList<>();

    protected Venda() {
    }

    public Long getNumero() { return numero; }

    public LocalDate getData() { return data; }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public BigDecimal subtotal(){
        return itens
                .stream()
                .map(item -> BigDecimal.valueOf((long) item.getQuantidade() * item.getPrecoUnitVenda()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }



}
