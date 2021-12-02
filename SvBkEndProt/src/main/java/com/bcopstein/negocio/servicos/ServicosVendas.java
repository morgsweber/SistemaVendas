package com.bcopstein.negocio.servicos;

import java.util.List;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.repositorios.IVendasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicosVendas{
    public IVendasRepository vendasRep;

    @Autowired
    public ServicosVendas(IVendasRepository vendasRep){
        this.vendasRep = vendasRep;
    }

    public List<Venda> todos(){
       return vendasRep.todos(); 
    }

    public boolean cadastra(Venda venda){
        return vendasRep.cadastra(venda);
    }

    public List<ItemVenda> getItensVenda(){
        return vendasRep.getItensVenda();
    }

    public Venda getVenda(){
        return vendasRep.getVenda();
    }
}