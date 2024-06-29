package com.grupo5.monolitoclean.application.dtos;

import com.grupo5.monolitoclean.domain.entities.PagamentoModel;

public record PagamentoDTO(
        int dia,
        int mes,
        int ano,
        long codass,
        double valorPago
) {
    public static PagamentoDTO fromModel(PagamentoModel pagamento) {
        return new PagamentoDTO(
                pagamento.getDataPagamento().getDayOfMonth(),
                pagamento.getDataPagamento().getMonth().getValue(),
                pagamento.getDataPagamento().getYear(),
                pagamento.getAssinatura().getCodigo(),
                pagamento.getValorPago()
        );
    }
}
