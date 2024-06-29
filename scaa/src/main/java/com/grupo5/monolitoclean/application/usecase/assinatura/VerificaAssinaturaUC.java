package com.grupo5.monolitoclean.application.usecase.assinatura;

import com.grupo5.monolitoclean.domain.services.AssinaturaService;
import org.springframework.stereotype.Component;

@Component
public class VerificaAssinaturaUC {
    private AssinaturaService assinaturaService;

    public VerificaAssinaturaUC(AssinaturaService assinaturaService){
        this.assinaturaService = assinaturaService;
    }

    public boolean run(long codAssinatura){
        return assinaturaService.verificaAssinatura(codAssinatura);
    }
}
