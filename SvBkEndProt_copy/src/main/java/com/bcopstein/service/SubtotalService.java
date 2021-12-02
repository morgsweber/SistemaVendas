package com.bcopstein.service;

import com.bcopstein.negocio.ItemCarrinho;
import com.bcopstein.negocio.Produto;
import com.bcopstein.repository.EstoqueRepository;
import com.bcopstein.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubtotalService {

    private final ProdutosRepository produtosRepository;

    @Autowired
    public SubtotalService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public Integer calcular(ItemCarrinho[] itens){
        int subtotal = 0;

        for (final ItemCarrinho it : itens) {
            // Procurar o produto pelo código
            Optional<Produto> prod = produtosRepository.findById((long) it.getCodigo());

            if (prod.isPresent()) {
                subtotal += (int) (prod.get().getPreco() * it.getQuantidade());
            } else {
                throw new IllegalArgumentException("Codigo invalido");
            }
        }

        return subtotal;
    }
}
