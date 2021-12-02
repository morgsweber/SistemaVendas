package com.bcopstein.adaptadores.repositorios;

import java.util.*;
import com.bcopstein.negocio.entidades.ItemEstoque;
import org.springframework.data.repository.CrudRepository;

public interface IEstoqueCRUD extends CrudRepository<ItemEstoque, Integer> {
    List<ItemEstoque> findAll();
    ItemEstoque findByIdProduto(int idProduto);
}