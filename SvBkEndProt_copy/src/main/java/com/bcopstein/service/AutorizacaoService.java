package com.bcopstein.service;

import com.bcopstein.repository.EstoqueRepository;
import com.bcopstein.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.OptionalLong;

@Component
public class AutorizacaoService {

    private final ProdutosRepository produtosRepository;
    private final EstoqueRepository estoqueRepository;

    @Autowired
    public AutorizacaoService(EstoqueRepository estoqueRepository, ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
        this.estoqueRepository = estoqueRepository;
    }

    public boolean isAutorizado(Long codProd, Integer qtdade){
        boolean produto = produtosRepository.existsById(codProd);
        Long quantidade  = estoqueRepository.findById(codProd).ifPresentOrElse(x -> x.getQuantidadeDisponivel());
    }
}
