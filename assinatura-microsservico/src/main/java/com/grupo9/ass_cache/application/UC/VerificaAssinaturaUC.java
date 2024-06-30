package com.grupo9.ass_cache.application.UC;


import com.grupo9.ass_cache.domain.service.AssinaturaService;
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
