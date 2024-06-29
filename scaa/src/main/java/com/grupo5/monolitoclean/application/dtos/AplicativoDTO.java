package com.grupo5.monolitoclean.application.dtos;

import com.grupo5.monolitoclean.domain.entities.AplicativoModel;

public record AplicativoDTO(long codigo, String nome, double custoMensal) {
    public static AplicativoDTO fromModel(AplicativoModel aplicativo) {
        return new AplicativoDTO(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }
}
