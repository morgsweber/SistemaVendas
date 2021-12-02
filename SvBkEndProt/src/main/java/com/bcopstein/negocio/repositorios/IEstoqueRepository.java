package com.bcopstein.negocio.repositorios;
import com.bcopstein.negocio.entidades.ItemEstoque;
import java.util.*;

public interface IEstoqueRepository{
    List<ItemEstoque> todos();
    boolean cadastra();
    ItemEstoque getEstoque();
    boolean deleta();
}
