package com.grupo5.monolitoclean.application.usecase.assinatura;

import com.grupo5.monolitoclean.application.dtos.AssinaturaDTO;
import com.grupo5.monolitoclean.domain.entities.AssinaturaModel;
import com.grupo5.monolitoclean.domain.repository.StatusAssinatura;
import com.grupo5.monolitoclean.domain.services.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssinaturasPorStatusUC {
    private AssinaturaService assinaturaService;

    @Autowired
    public AssinaturasPorStatusUC(AssinaturaService assinaturaService){
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run(String statusAssinaturaString){
        List<AssinaturaModel> listaDeAssinaturas = assinaturaService.listarAssinaturasPorStatus(statusAssinaturaString);
        return listaDeAssinaturas.stream()
            .map(a->AssinaturaDTO.fromModel(a))
            .toList();
    }
}
