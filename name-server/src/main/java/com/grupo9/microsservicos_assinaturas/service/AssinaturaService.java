package com.grupo9.microsservicos_assinaturas.service;

@service
public class AssinaturaService{

private CacheService CacheService;

    public AssinaturaService(CacheService cacheService){
        this.cacheService = cacheService;
    }

    public boolean verificaAssinatura(long codass){
        return cacheService.verificaStatusAssinatura(codass);
    }
}