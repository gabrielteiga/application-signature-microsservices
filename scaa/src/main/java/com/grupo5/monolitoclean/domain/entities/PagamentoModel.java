package com.grupo5.monolitoclean.domain.entities;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class PagamentoModel {
    private long codigo;
    private AssinaturaModel assinatura;
    private double valorPago;
    private LocalDate dataPagamento;
    private String promocao;


    public PagamentoModel(long codigo, AssinaturaModel assinatura, double valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }

    public AssinaturaModel getAssinatura() {
        return assinatura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

}
