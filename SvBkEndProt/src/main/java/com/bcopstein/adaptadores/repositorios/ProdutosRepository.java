
package com.bcopstein.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import com.bcopstein.adaptadores.repositorios.IProdutosCRUD;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutosRepository;



@Component
public class ProdutosRepository implements IProdutosRepository{
    private IProdutosCRUD produtosCRUD;

    @Autowired
    public ProdutosRepository(IProdutosCRUD produtosCRUD){
        this.produtosCRUD = produtosCRUD;
    }

    @Override
    public List<Produto> todos(){
        return produtosCRUD.findAll();
    }

    @Override
    public boolean cadastra(Produto prod){
        produtosCRUD.save(prod);
        return true;
    }

    @Override 
    public Produto getProduto(int id){
        return produtosCRUD.findByCodigo(id);
    }

    @Override
    public boolean deleta(){
        return true;
    }

}