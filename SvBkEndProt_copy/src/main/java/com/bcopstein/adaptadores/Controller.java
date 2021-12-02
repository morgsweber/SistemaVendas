package com.bcopstein.adaptadores;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.negocio.ItemCarrinho;
import com.bcopstein.negocio.ItemEstoque;
import com.bcopstein.negocio.Produto;
import com.bcopstein.service.ListarProdutosService;
import com.bcopstein.service.SubtotalService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class Controller {
  private List<Produto> produtos;
  private List<String> vendasEfetuadas;

  private ListarProdutosService listarProdutosService;
  private SubtotalService subtotalService;

  public Controller(ListarProdutosService listarProdutosService, SubtotalService subtotalService) {
    this.subtotalService = subtotalService;
    this.listarProdutosService = listarProdutosService;
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return listarProdutosService.listar();
  }

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final Long codProd,
                            @RequestParam final Integer qtdade) {
    //final boolean disponivel =  produtos.stream().anyMatch(p -> p.getCodigo() == codProd && p.getQtdade() >= qtdade);
    return true;
  }

  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaVenda(@RequestBody final ItemCarrinho[] itens) {

    ArrayList<Produto> listaProdutos = new ArrayList<>();
    ArrayList<Integer> listaQtdades = new ArrayList<>();

    for (ItemCarrinho item : itens) {
      final Produto produto =
          produtos.stream().filter(p -> p.getCodigo() == item.getCodigo()).findAny().orElse(null);

      if (produto == null) {
        return false;
      }

      listaQtdades.add(item.getQuantidade());
      listaProdutos.add(produto);
    }

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < listaProdutos.size(); i++) {
      final Produto produto = listaProdutos.get(i);
      final int qtdade = listaQtdades.get(i);
      //produto.saidaDeProduto(qtdade);

      builder.append(produto.getCodigo());
      builder.append(" ");
      builder.append(produto.getDescricao());
      builder.append(" ");
      builder.append(qtdade);
      builder.append("\n");
    }

    vendasEfetuadas.add(builder.toString());
    return true;
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<String> vendasEfetuadas() {
    return vendasEfetuadas;
  }

  @PostMapping("/subtotal")
  @CrossOrigin(origins = "*")
  public Integer calculaSubtotal(@RequestBody final ItemCarrinho[] itens) {
      return subtotalService.calcular(itens);
  }}
