package com.bcopstein.adaptadores.repositorios;

import java.util.*;

import com.bcopstein.negocio.entidades.Produto;
import org.springframework.data.repository.CrudRepository;

public interface IProdutosCRUD extends CrudRepository<Produto, Integer> {
    List<Produto> findAll();
    Produto findByCodigo(int codigo);
}
