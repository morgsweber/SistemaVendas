package com.bcopstein.aplicacao.usecases;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.adaptadores.dtos.ItemCarrinho;


import com.bcopstein.negocio.servicos.ServicosVendas;
import com.bcopstein.aplicacao.servicos.ServicoImposto;
import com.bcopstein.negocio.servicos.ServicosEstoque;
import com.bcopstein.negocio.servicos.ServicoDeProduto;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UC_EfetivarVenda{
    private ServicosVendas servicosVendas;
    private ServicoImposto servicoImposto;
    private ServicosEstoque servicosEstoque;
    private ServicoDeProduto servicoDeProduto;

    @Autowired
    public UC_EfetivarVenda(ServicosVendas servicosVendas, ServicoImposto servicoImposto,
    ServicosEstoque servicosEstoque, ServicoDeProduto servicoDeProduto){
        this.servicosVendas = servicosVendas;
        this.servicoImposto = servicoImposto;
        this.servicosEstoque = servicosEstoque;
        this.servicoDeProduto = servicoDeProduto;
    }

    public boolean run(ItemCarrinho[] carrinho){
        if(carrinho == null)
            return false;

        ArrayList<ItemVenda> itensVenda = new ArrayList<>();

        double total = 0;
        double imposto = 0;
        for(ItemCarrinho item: carrinho){
            Produto prod = servicoDeProduto.getProduto(item.getCodigo());

            total += prod.getPreco() * item.getQuantidade();
            imposto += servicoImposto.calculaImpostos(prod.getPreco());

            ItemEstoque itemEstoque = servicosEstoque.getEstoque(prod.getCodigo());
            servicosEstoque.remove(itemEstoque, item.getQuantidade());

            ItemVenda itemVenda = new ItemVenda(item.getQuantidade(), prod.getPreco());

            itensVenda.add(itemVenda) ;
        }

        Date data = new Date();
        Venda venda = new Venda(data, itensVenda, imposto, total+imposto);
        return servicosVendas.cadastra(venda);
    }
}