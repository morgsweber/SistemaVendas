package com.bcopstein.negocio.entidades;
import javax.persistence.*;

@Entity
public class ItemVenda{

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private int quantidade;
    private double precoUnitVenda;

    public ItemVenda(int quantidade, double precoUnitVenda){
        this.quantidade = quantidade;
        this.precoUnitVenda = precoUnitVenda;
    }

    protected ItemVenda(){}

    public void setId(long id){
        this.id = id;
    }

    public void setQuantidade(int qnt){
        this.quantidade = quantidade;
    }

    public void setPrecoUnitVenda(double precoUnitVenda){
        this.precoUnitVenda = precoUnitVenda;
    }

    public long getId(){
        return id;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public double getPrecoUnitVenda(){
        return precoUnitVenda;
    }

}
