package com.grupo5.monolitoclean.application.usecase.aplicativo;

import com.grupo5.monolitoclean.application.dtos.AplicativoDTO;
import com.grupo5.monolitoclean.domain.entities.AplicativoModel;
import com.grupo5.monolitoclean.domain.services.AplicativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraAplicativoUC {
    private AplicativoService cadastraAplicativo;

    @Autowired
    public CadastraAplicativoUC(AplicativoService cadastraAplicativo) {
        this.cadastraAplicativo = cadastraAplicativo;
    }

    public AplicativoDTO run(AplicativoModel aplicativoModel) {
        AplicativoModel aplicativo = cadastraAplicativo.registrarAplicativo(aplicativoModel);
        return AplicativoDTO.fromModel(aplicativo);
    }
}
