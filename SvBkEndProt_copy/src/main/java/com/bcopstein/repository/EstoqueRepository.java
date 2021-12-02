package com.bcopstein.repository;

import com.bcopstein.negocio.ItemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<ItemEstoque, Long> {

}
