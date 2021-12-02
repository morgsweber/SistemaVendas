package com.bcopstein.negocio.entidades;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemVenda{

    @Id 
    private int id;
    private int quantidade;
    private float precoUnitVenda;
    private float imposto;

    public ItemVenda(int id, int quantidade, float precoUnitVenda, float imposto){
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitVenda = precoUnitVenda;
        this.imposto = imposto;
    }

    protected ItemVenda(){}

    public void setId(int id){
        this.id = id;
    }

    public void setQuantidade(int qnt){
        this.quantidade = quantidade;
    }

    public void setPrecoUnitVenda(float precoUnitVenda){
        this.precoUnitVenda = precoUnitVenda;
    }

    public void setImposto(float imposto){
        this.imposto = imposto;
    }

    public int getId(){
        return id;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public float getPrecoUnitVenda(){
        return precoUnitVenda;
    }
    
    public float imposto(){
        return imposto;
    }

}
