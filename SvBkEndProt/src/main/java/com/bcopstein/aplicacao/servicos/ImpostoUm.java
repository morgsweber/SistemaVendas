package com.bcopstein.aplicacao.servicos;
import org.springframework.beans.factory.annotation.Autowired;

public class ImpostoUm implements ICalculaImposto{
    private final double IMPOSTO = 0.10;

    @Autowired
    public ImpostoUm(){}

    public double calculaImposto(double valor){return valor * IMPOSTO;}
}