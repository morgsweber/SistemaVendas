package com.bcopstein.negocio.servicos;
import java.util.List;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoDeProduto{
    public IProdutosRepository produtoRep;

    @Autowired
    public ServicoDeProduto(IProdutosRepository produtoRep){
        this.produtoRep = produtoRep;
    }

    public List<Produto> todos(){
        return produtoRep.todos();
    }

    public boolean cadastra(){
        return produtoRep.cadastra();
    }

    public Produto getProduto(){
        return produtoRep.getProduto();
    }

    public boolean deleta(){
        return produtoRep.deleta();
    }
} 