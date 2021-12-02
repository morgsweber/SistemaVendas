package com.bcopstein.negocio.repositorios;
import com.bcopstein.negocio.entidades.ItemEstoque;
import java.util.*;

public interface IEstoqueRepository{
    List<ItemEstoque> todos();
    boolean cadastra(ItemEstoque item);
    ItemEstoque getEstoque(int cod);
    boolean deleta();
    boolean remove(ItemEstoque item, int qtd);
}
