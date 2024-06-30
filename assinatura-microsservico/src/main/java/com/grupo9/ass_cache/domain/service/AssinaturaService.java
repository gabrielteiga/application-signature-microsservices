package com.grupo9.ass_cache.domain.service;


import com.grupo9.ass_cache.domain.repository.IAssinaturaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class AssinaturaService {
    private IAssinaturaRepository assinaturaRepository;


    public AssinaturaService(IAssinaturaRepository assinaturaRepository){
        this.assinaturaRepository = assinaturaRepository;
    }

    public boolean verificaAssinatura(long codAssinatura) {
        if(assinaturaRepository.buscaAssinaturaPorCodigo(codAssinatura).getFimVigencia().isBefore(LocalDate.now())){
            return true;
        }
        return false;
    }
}
