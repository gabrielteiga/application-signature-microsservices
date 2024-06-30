package com.grupo5.monolitoclean;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "validateSubscription-microservice")
public interface AssinaturaProxy {

    @GetMapping("/assinvalida/{codass}")
    boolean verificaAssinatura(@PathVariable long codass);
}
