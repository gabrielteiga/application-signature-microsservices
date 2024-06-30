package com.grupo5.monolitoclean.domain.repository;

import com.grupo5.monolitoclean.domain.entities.AssinaturaModel;

import java.time.Instant;
import java.time.LocalDate;

public enum StatusAssinatura {
    ATIVA ("Ativa"),
    CANCELADA ("Cancelada");


    private String nome;

    StatusAssinatura(String nome){
        this.nome = nome;
    }

    public String getNome(AssinaturaModel assinaturaModel){
        if (assinaturaModel.getFimVigencia().isBefore(LocalDate.now())){
            return this.nome ="Ativa";
        }
        return this.nome ="Cancelada";
    }
}
