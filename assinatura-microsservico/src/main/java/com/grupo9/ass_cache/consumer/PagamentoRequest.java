package com.grupo9.ass_cache.consumer;

import com.grupo9.ass_cache.producer.PagamentoErroProdutor;
import com.grupo9.ass_cache.producer.PagamentoSucessoProdutor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PagamentoRequest {
    @Autowired private PagamentoSucessoProdutor sucessoProdutor;
    @Autowired private PagamentoErroProdutor erroProdutor;

    @RabbitListener(queues = {"pagamento-request-queue"})
    public void receberMensagem(@Payload Message message){
        System.out.println(message);
        if (new Random().nextBoolean()){
            sucessoProdutor.gerarResposta("Pagamento recebido com sucesso " + message);
        }else {
            erroProdutor.gerarResposta("ERRO no pagamento " + message);
        }
    }
}
