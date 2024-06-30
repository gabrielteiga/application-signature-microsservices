package com.grupo5.monolitoclean.application.consumer;

import com.grupo5.monolitoclean.application.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PagamentoResponseSucesso {
    @Autowired private PagamentoFacade pagamentoFacade;

    @RabbitListener(queues = {"pagamento-request-sucesso-queue"})
    public void receive(@Payload Message message){
        String payload = String.valueOf(message.getPayload());
        pagamentoFacade.sucessoPagamento(payload);
    }
}
