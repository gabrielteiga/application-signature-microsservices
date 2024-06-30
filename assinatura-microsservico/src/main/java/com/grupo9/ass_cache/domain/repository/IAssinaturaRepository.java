package com.grupo9.ass_cache.domain.repository;

import com.grupo9.ass_cache.domain.entities.AssinaturaModel;


public interface IAssinaturaRepository {
    AssinaturaModel buscaAssinaturaPorCodigo(long codigoDaAssinatura);
}
