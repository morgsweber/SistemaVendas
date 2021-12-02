package com.bcopstein.aplicacao.usecases;

import java.util.*;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoDeProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UC_ConsultarProduto{
    private ServicoDeProduto servicoDeProduto;
    
    @Autowired
    public UC_ConsultarProduto(ServicoDeProduto servicoDeProduto){
        this.servicoDeProduto = servicoDeProduto;
    }

    public List<Produto> run() {
        return servicoDeProduto.todos();
    }
}