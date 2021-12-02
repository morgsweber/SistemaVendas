package com.bcopstein.negocio.repositorios;
import com.bcopstein.negocio.entidades.Produto;
import java.util.*;

public interface IProdutosRepository{
    List<Produto> todos();
    boolean cadastra();
    Produto getProduto();
    boolean deleta();
}