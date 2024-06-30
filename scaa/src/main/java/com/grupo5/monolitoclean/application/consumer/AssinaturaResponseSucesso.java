package com.grupo5.monolitoclean.application.consumer;

import com.grupo5.monolitoclean.application.facade.AssinaturaFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaResponseSucesso {
    @Autowired private AssinaturaFacade assinaturaFacade;

    @RabbitListener(queues = {"pagamento-response-sucesso-queue"})
    public void receive(@Payload Message message){
        String payload = String.valueOf(message.getPayload());
        assinaturaFacade.sucessoAssinatura(payload);
    }
}
