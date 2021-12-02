package com.bcopstein.negocio.repositorios;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.entidades.ItemVenda;
import java.util.*;

public interface IVendasRepository{
   List<Venda> todos();
   boolean cadastra();
   Venda getVenda();
   List<ItemVenda> getItensVenda();
}