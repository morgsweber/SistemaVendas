package com.bcopstein.adaptadores.configurador;

import com.bcopstein.aplicacao.servicos.ICalculaImposto;
import com.bcopstein.aplicacao.servicos.ImpostoUm;
import com.bcopstein.aplicacao.servicos.ImpostoDois;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImpostoConfigurador{

    @Autowired
    public ImpostoConfigurador(){}

    @Bean
    @ConditionalOnProperty(name="imposto", havingValue="um", matchIfMissing=true)
    public ICalculaImposto impostoUm() {
        return new ImpostoUm();
    }

    @Bean
    @ConditionalOnProperty(name="imposto", havingValue="dois")
    public ICalculaImposto impostoDois() {
        return new ImpostoDois();
    }

}