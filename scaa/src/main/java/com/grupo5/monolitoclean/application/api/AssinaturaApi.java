package com.grupo5.monolitoclean.application.api;

import com.grupo5.monolitoclean.application.dtos.AssinaturaDTO;
import com.grupo5.monolitoclean.application.facade.AssinaturaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaApi {
    @Autowired private AssinaturaFacade assinaturaFacade;

    @PostMapping
    public String processarAssinatura(@RequestBody AssinaturaDTO assinaturaDTO) {
        return assinaturaFacade.VerificaAssinatura(assinaturaDTO);
    }
}
