package com.grupo5.monolitoclean.application.usecase.pagamento;

import com.grupo5.monolitoclean.application.dtos.PagamentoDTO;
import com.grupo5.monolitoclean.application.dtos.PagamentoStatusDTO;
import com.grupo5.monolitoclean.domain.entities.PagamentoModel;
import com.grupo5.monolitoclean.domain.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistraPagamentoUC {
    private PagamentoService pagamentoService;

    public RegistraPagamentoUC(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    public PagamentoStatusDTO run(PagamentoDTO pagamentoDTO){
        PagamentoModel pagamento = pagamentoService.registraPagamento(pagamentoDTO);
        return PagamentoStatusDTO.fromPagamentoDTO(
                PagamentoDTO.fromModel(pagamento),
                true
        );
    }
}
