package com.grupo5.monolitoclean.application.dtos;

import com.grupo5.monolitoclean.domain.entities.AplicativoModel;
import com.grupo5.monolitoclean.domain.entities.AssinaturaModel;
import com.grupo5.monolitoclean.domain.entities.ClienteModel;

import java.time.LocalDate;
import java.util.Date;

public record AssinaturaDTO(
        long codigo,
        AplicativoModel aplicativo,
        ClienteModel cliente,
        LocalDate inicioVigencia,
        LocalDate fimVigencia
) {
    public static AssinaturaDTO fromModel(AssinaturaModel assinatura) {
        return new AssinaturaDTO(
                assinatura.getCodigo(),
                assinatura.getAplicativo(),
                assinatura.getCliente(),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia()
        );
    }
}
