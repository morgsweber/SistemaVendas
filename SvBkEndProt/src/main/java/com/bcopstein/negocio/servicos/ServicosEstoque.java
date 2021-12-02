package com.bcopstein.negocio.servicos;
import java.util.List;
import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicosEstoque{
    public IEstoqueRepository estoqueRep;

    @Autowired
    public ServicosEstoque(IEstoqueRepository estoqueRep){
        this.estoqueRep = estoqueRep;
    }

    public List<ItemEstoque> todos(){
        return estoqueRep.todos();
    }

    public boolean cadastra(){
        return estoqueRep.cadastra();
    }

    public ItemEstoque getEstoque(){
        return estoqueRep.getEstoque();
    }

    public boolean deleta(){
        return estoqueRep.deleta();
    }
} 