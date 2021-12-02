package com.bcopstein.aplicacao.usecases;

import com.bcopstein.negocio.servicos.ServicosEstoque;
import com.bcopstein.negocio.servicos.ServicoDeProduto;
import com.bcopstein.negocio.entidades.ItemEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.*;
@Component
public class UC_SelecionarProduto{
    private ServicoDeProduto servicoDeProduto;
    private ServicosEstoque servicosEstoque;

    @Autowired
    public UC_SelecionarProduto(ServicoDeProduto servicoDeProduto, ServicosEstoque servicosEstoque){
        this.servicosEstoque = servicosEstoque;
        this.servicoDeProduto = servicoDeProduto;
    }

    public boolean run(int codigo, int quantidade){
        ItemEstoque item = servicosEstoque.getEstoque(codigo);
        if(item == null){
            return false;
        }

        if( item.getQtdDisponivel() >= quantidade)
            return true;
        return false;

        }
}