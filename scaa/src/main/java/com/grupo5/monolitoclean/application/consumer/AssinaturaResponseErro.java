package com.grupo5.monolitoclean.application.consumer;

import com.grupo5.monolitoclean.application.facade.AssinaturaFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AssinaturaResponseErro {
    @Autowired private AssinaturaFacade assinaturaFacade;

    @RabbitListener(queues = {"assinatura-response-erro-queue"})
    public void receive(@Payload Message message){
        System.out.println("Receive Message: " + message.toString() + "  " + LocalDate.now());
        String payload = String.valueOf(message.getPayload());

        assinaturaFacade.erroAssinatura(payload);
    }
}
