package com.bcopstein.negocio.entidades;
import javax.persistence.*;
import java.util.*;

@Entity
public class Venda{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long numero;
    @OneToMany
    private List<ItemVenda> itensVenda;
    private Date data;
    private double imposto;
    private double total;


    public Venda(Date data, List<ItemVenda> itensVenda, double imposto, double total){
        this.data = data;
        this.itensVenda = itensVenda;
        this.imposto = imposto;
        this.total = total;
    }

    protected Venda(){}

    public long getNumero(){
        return numero;
    }

    public Date getData(){
        return data;
    }
    
    public void setData(Date data){
        this.data = data;
    }

    public void setNumero(long numero){
        this.numero = numero;
    }

    public List<ItemVenda> getItensVenda(){
        return itensVenda;
    }


}