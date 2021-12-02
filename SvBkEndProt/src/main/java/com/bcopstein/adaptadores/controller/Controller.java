package com.bcopstein.adaptadores.controller;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.adaptadores.dtos.ItemCarrinho;

import com.bcopstein.aplicacao.usecases.UC_ConsultarProduto;
import com.bcopstein.aplicacao.usecases.UC_ConsultarSubtotal;
import com.bcopstein.aplicacao.usecases.UC_EfetivarVenda;
import com.bcopstein.aplicacao.usecases.UC_SelecionarProduto;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/vendas")
public class Controller {
  private UC_ConsultarProduto consultarProduto;
  private UC_ConsultarSubtotal consultarSubtotal;
  private UC_EfetivarVenda efetivarVenda;
  private UC_SelecionarProduto selecionarProduto;

  @Autowired
  public Controller(UC_ConsultarProduto consultarProduto, UC_ConsultarSubtotal consultarSubtotal,
                                      UC_EfetivarVenda efetivarVenda, UC_SelecionarProduto selecionarProduto) {
                                        
                                        this.consultarProduto = consultarProduto;
                                        this.consultarSubtotal = consultarSubtotal;
                                        this.efetivarVenda = efetivarVenda;
                                        this.selecionarProduto = selecionarProduto;

  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return consultarProduto.run();
  }

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final Integer codProd,
                            @RequestParam final Integer qtdade) {
    return selecionarProduto.run(codProd, qtdade);
  }

  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaVenda(@RequestBody final ItemCarrinho[] itens) {
    return efetivarVenda.run(itens);
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<String> vendasEfetuadas() {
    return null;
  }

  @PostMapping("/subtotal")
  @CrossOrigin(origins = "*")
  public double[] calculaSubtotal(@RequestBody final ItemCarrinho[] itens) {
    return consultarSubtotal.run(itens);
  }}
