package com.grupo9.ass_cache.controller;


import com.grupo9.ass_cache.application.UC.VerificaAssinaturaUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {


    private VerificaAssinaturaUC verificaAssinatura;

    @Autowired
    public AssinaturaController(VerificaAssinaturaUC verificaAssinatura) {
        this.verificaAssinatura = verificaAssinatura;
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean verificaAssinatura(@PathVariable long codass){
        return verificaAssinatura.run(codass);
    }
}
