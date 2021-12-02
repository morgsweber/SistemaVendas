package com.bcopstein.negocio.entidades;
import javax.persistence.*;
import java.util.*;

@Entity
public class Venda{
    @Id
    private int id;
    private int numero;
    @OneToMany
    private List<ItemVenda> itensVenda;
    private Date data;


    public Venda(int id, int numero, Date data){
        this.id = id;
        this.numero = numero;
        this.data = data;
    }

    protected Venda(){}

    public int getNumero(){
        return numero;
    }

    public Date getData(){
        return data;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public void setData(Date data){
        this.data = data;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public List<ItemVenda> getItensVenda(){
        return itensVenda;
    }


}