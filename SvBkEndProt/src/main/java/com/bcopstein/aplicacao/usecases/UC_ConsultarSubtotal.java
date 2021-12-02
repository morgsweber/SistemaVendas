package com.bcopstein.aplicacao.usecases;

import com.bcopstein.adaptadores.dtos.ItemCarrinho;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoDeProduto;
import com.bcopstein.aplicacao.servicos.ServicoImposto;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UC_ConsultarSubtotal{
    private ServicoDeProduto servicoDeProduto;
    private ServicoImposto servicoImposto;

    @Autowired
    public UC_ConsultarSubtotal(ServicoDeProduto servicoDeProduto, ServicoImposto servicoImposto) {
        this.servicoDeProduto = servicoDeProduto;
        this.servicoImposto = servicoImposto;
    }

    public double[] run(ItemCarrinho[] carrinho){
        double val[] = new double[3];
        double total = 0.0;
        double imposto = 0.0;

        for(ItemCarrinho item: carrinho){
            Produto prod = servicoDeProduto.getProduto(item.getCodigo());
            total += prod.getPreco() * item.getQuantidade();
            imposto += servicoImposto.calculaImpostos(prod.getPreco());
        }

        val[0] = total;
        val[1] = imposto;
        val[2] = total + imposto;
        return val;
    }
}