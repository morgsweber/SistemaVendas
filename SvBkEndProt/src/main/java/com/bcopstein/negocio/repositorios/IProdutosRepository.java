package com.bcopstein.negocio.repositorios;
import com.bcopstein.negocio.entidades.Produto;
import java.util.*;

public interface IProdutosRepository{
    List<Produto> todos();
    boolean cadastra(Produto prod);
    Produto getProduto(int cod);
    boolean deleta();
}