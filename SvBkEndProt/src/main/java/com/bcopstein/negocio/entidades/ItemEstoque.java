package com.bcopstein.negocio.entidades;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemEstoque{
    @Id
    private int id;
    private int qtdDisponivel;
    private int idProduto;

    public ItemEstoque(int id, int qtdade, int idProduto){
        this.id = id;
        this.qtdDisponivel = qtdade;
        this.idProduto = idProduto;
    }

    protected ItemEstoque(){}

    public int getId(){
        return id;
    }

    public int getQtdDisponivel(){
        return qtdDisponivel;
    }

    public int getIdProduto(){
        return idProduto;
    }
    public void setId(int id){
        this.id = id;
    }

    public void setQtdDisponivel(int qtdDisponivel){
        this.qtdDisponivel = qtdDisponivel;
    }

    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }
}