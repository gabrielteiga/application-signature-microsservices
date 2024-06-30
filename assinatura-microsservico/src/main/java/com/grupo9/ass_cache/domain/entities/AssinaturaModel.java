package com.grupo9.ass_cache.domain.entities;

import java.time.LocalDate;

public class AssinaturaModel {
    private long codigo;
    private LocalDate fimVigencia;


    public AssinaturaModel(long codigo, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.fimVigencia = fimVigencia;
    }

    public long getCodigo() {
        return codigo;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }


}
