package com.bcopstein.negocio.entidades;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
  @Id
  private int codigo;
  private String descricao;
  private double preco;

  public Produto(int codigo, String descricao, double preco) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.preco = preco;
  }

  protected Produto(){}

  public int getCodigo() {
    return codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  @Override
  public String toString() {
    return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + "]";
  }
}
