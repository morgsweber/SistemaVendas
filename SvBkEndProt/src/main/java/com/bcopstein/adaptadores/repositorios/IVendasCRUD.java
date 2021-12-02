package com.bcopstein.adaptadores.repositorios;

import java.util.*;

import com.bcopstein.negocio.entidades.Venda;
import org.springframework.data.repository.CrudRepository;

public interface IVendasCRUD extends CrudRepository<Venda, Long> {
    List<Venda> findAll();
    Venda findByNumero(int code);
}
