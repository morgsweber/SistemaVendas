package com.bcopstein.negocio;

import javax.persistence.*;

@Entity
public class Produto {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long codigo;

  private String descricao;

  private String nome;

  private Double preco;

  @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private ItemEstoque itemEstoque;

  public Produto(){}

  public String getNome() {
    return nome;
  }

  public Long getCodigo() {
    return codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }
}
