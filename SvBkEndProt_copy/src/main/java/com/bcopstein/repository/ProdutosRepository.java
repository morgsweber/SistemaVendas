package com.bcopstein.repository;

import com.bcopstein.negocio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Long> {

}
