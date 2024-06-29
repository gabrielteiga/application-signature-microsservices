package com.grupo5.monolitoclean.application.usecase.aplicativo;

import com.grupo5.monolitoclean.application.dtos.AplicativoDTO;
import com.grupo5.monolitoclean.domain.services.AplicativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AplicativosCadastradosUC {
    private AplicativoService aplicativoService;

    @Autowired
    public AplicativosCadastradosUC(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    public List<AplicativoDTO> run() {
        return aplicativoService.aplicativosCadastrados().stream()
            .map(a -> AplicativoDTO.fromModel(a))
            .toList();
    }
}
