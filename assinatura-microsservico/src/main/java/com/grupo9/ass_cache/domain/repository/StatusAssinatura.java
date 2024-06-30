package com.grupo9.ass_cache.domain.repository;

public enum StatusAssinatura {
    ATIVA ("Ativa"),
    CANCELADA ("Cancelada");


    private String nome;

    private StatusAssinatura(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
