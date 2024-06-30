package com.grupo5.monolitoclean.application.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.grupo5.monolitoclean.application.dtos.AssinaturaDTO;
import com.grupo5.monolitoclean.application.producer.AssinaturaRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaFacade {
    @Autowired private AssinaturaRequestProducer producer;

    public String VerificaAssinatura(AssinaturaDTO request) {
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao verificar assinatura .. " + e.getMessage();
        }
        return "true";
    }

    public void erroAssinatura(String payload) {
        System.err.println("==== RESPOSTA ERRO ====" + payload);
    }

    public void sucessoAssinatura(String payload) {
        System.err.println("==== RESPOSTA SUCESSO ====" + payload);
    }
}
