package com.bcopstein.service;

import com.bcopstein.negocio.Produto;
import com.bcopstein.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarProdutosService {

    private final ProdutosRepository produtosRepository;

    @Autowired
    public ListarProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }


    public List<Produto> listar() {
        return produtosRepository.findAll();
    }
}
