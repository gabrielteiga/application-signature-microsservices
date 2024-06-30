package com.grupo5.monolitoclean.application.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.grupo5.monolitoclean.application.dtos.PagamentoDTO;
import com.grupo5.monolitoclean.application.producer.PagamentoRequestProducer;
import com.grupo5.monolitoclean.domain.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoFacade {
    @Autowired private PagamentoRequestProducer producer;

    public String solicitarPagamento(PagamentoDTO request){
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao solicitar pagamento .. " + e.getMessage();
        }
        return "Pagamento aguardando confirmacao...";
    }

    public void erroPagamento(String payload){
        System.err.println("==== RESPOSTA ERRO ====" + payload);
    }

    public void sucessoPagamento(String payload){
        System.err.println("==== RESPOSTA SUCESSO ====" + payload);
    }
}
