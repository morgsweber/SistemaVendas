package com.bcopstein.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.repositorios.IVendasRepository;
import com.bcopstein.adaptadores.repositorios.IVendasCRUD;


@Component
public class VendasRepository implements IVendasRepository{
    private IVendasCRUD vendasCRUD;

    @Autowired
    public VendasRepository(IVendasCRUD vendasCRUD){
        this.vendasCRUD = vendasCRUD;
    }

    @Override
    public List<Venda> todos(){
        return vendasCRUD.findAll();
    }

    @Override
    public boolean cadastra(Venda venda){
        vendasCRUD.save(venda);
        return true;
    }

    @Override
    public Venda getVenda(){
        return new Venda(new Date(), new ArrayList<ItemVenda>(), 0.0, 0.0);
    }

    @Override
    public List<ItemVenda> getItensVenda(){
        return new ArrayList<ItemVenda>();
    }

}