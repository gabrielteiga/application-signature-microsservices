package com.grupo5.monolitoclean.application.usecase.assinatura;

import com.grupo5.monolitoclean.application.dtos.AssinaturaDTO;
import com.grupo5.monolitoclean.domain.services.AssinaturaService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarAssinaturasDoClienteUC {
    private AssinaturaService assinaturaService;

    public ListarAssinaturasDoClienteUC(AssinaturaService assinaturaService){
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run(long codCliente){
        return assinaturaService.listarAssinaturasDoCliente(codCliente).stream()
            .map(a -> AssinaturaDTO.fromModel(a))
            .toList();
    }
}
