package com.grupo5.monolitoclean.application.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo5.monolitoclean.application.dtos.PagamentoDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRequestProducer {
    @Autowired AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integrar(PagamentoDTO pagamentoDTO) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "pagamento-request",
                "pagamento-request-rout-key",
                objectMapper.writeValueAsString(pagamentoDTO)
        );
    }
}
