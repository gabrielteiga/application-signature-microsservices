package com.grupo9.ass_cache.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoErroProdutor {
@Autowired private AmqpTemplate amqpTemplate;


    public void gerarResposta(String mensagem) {
        amqpTemplate.convertAndSend(
                "pagamento-response-erro",
                "pagamento-response-erro-rout-key",
                mensagem
        );
    }
}
