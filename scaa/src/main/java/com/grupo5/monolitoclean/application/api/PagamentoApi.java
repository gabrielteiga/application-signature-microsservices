package com.grupo5.monolitoclean.application.api;

import com.grupo5.monolitoclean.application.dtos.PagamentoDTO;
import com.grupo5.monolitoclean.application.facade.PagamentoFacade;
import com.grupo5.monolitoclean.domain.services.PagamentoService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoApi {
    @Autowired private PagamentoFacade pagamentoFacade;

    @PostMapping
    public String processar(@RequestBody PagamentoDTO request){
        return pagamentoFacade.solicitarPagamento(request);
    }
}
