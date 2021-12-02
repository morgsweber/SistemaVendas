package com.bcopstein.repository;

import com.bcopstein.negocio.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<Venda,Long> {
}
