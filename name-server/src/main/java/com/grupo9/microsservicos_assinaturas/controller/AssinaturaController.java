package com.grupo9.microsservicos_assinaturas.controller;

import com.grupo9.microsservicos_assinaturas.service.AssinaturaService;

@RestController
@RequestMapping("/servcad")
public class AssinaturaController{
private final AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService){
            this.assinaturaService = assinaturaService;
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean verificaAssinatura(@PathVariable long codass){
        return assinaturaService
    }

    
    

}