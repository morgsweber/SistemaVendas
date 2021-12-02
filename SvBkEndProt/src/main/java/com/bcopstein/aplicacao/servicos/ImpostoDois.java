package com.bcopstein.aplicacao.servicos;
import org.springframework.beans.factory.annotation.Autowired;

public class ImpostoDois implements ICalculaImposto{
    private double IMPOSTO = 0.20;

    @Autowired
    public ImpostoDois(){}

    public double calculaImposto(double valor){
        if( valor > 10000) 
            IMPOSTO = 0.30;

        return valor * IMPOSTO;
        }
}