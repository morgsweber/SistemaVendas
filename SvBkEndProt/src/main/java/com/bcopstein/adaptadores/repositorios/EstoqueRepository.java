package com.bcopstein.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;

@Component
public class EstoqueRepository implements IEstoqueRepository{
    private IEstoqueCRUD estoqueCRUD;

    @Autowired
    public EstoqueRepository(IEstoqueCRUD estoqueCRUD){
        this.estoqueCRUD = estoqueCRUD;
    }

    @Override
    public List<ItemEstoque> todos(){
        return estoqueCRUD.findAll();
    }

    @Override
    public boolean cadastra(ItemEstoque item){
        estoqueCRUD.save(item);
        return true;
    }

    @Override
    public ItemEstoque getEstoque(int cod){
        return estoqueCRUD.findByIdProduto(cod);
    }

    @Override
    public boolean deleta(){
        return true;
    }

    @Override
    public boolean remove(ItemEstoque item, int qtd){
        item.setQtdDisponivel(item.getQtdDisponivel() - qtd);
        estoqueCRUD.save(item);
        return true;
    }
}