package com.grupo5.monolitoclean.application.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo5.monolitoclean.application.dtos.AssinaturaDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssinaturaRequestProducer {
    @Autowired private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integrar(AssinaturaDTO assinaturaDTO) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "assinatura-request",
                "assinatura-request-rout-key",
                objectMapper.writeValueAsString(assinaturaDTO)
        );
    }
}
