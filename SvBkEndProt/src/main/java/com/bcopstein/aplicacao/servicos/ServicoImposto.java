package com.bcopstein.aplicacao.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoImposto {
    private ICalculaImposto calculaImposto;

    @Autowired
    public ServicoImposto(ICalculaImposto calculaImposto){
        this.calculaImposto = calculaImposto;
    }

    public double calculaImpostos(double valor){
        return calculaImposto.calculaImposto(valor);
    }
}
