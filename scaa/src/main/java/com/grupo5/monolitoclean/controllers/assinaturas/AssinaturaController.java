package com.grupo5.monolitoclean.controllers.assinaturas;

import com.grupo5.monolitoclean.AssinaturaProxy;
import com.grupo5.monolitoclean.application.dtos.AssinaturaDTO;
import com.grupo5.monolitoclean.application.dtos.CodigosDTO;
import com.grupo5.monolitoclean.application.usecase.assinatura.*;
import com.grupo5.monolitoclean.domain.entities.AssinaturaModel;
import com.grupo5.monolitoclean.domain.repository.StatusAssinatura;
import com.grupo5.monolitoclean.repository.AssinaturaMemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servcad")
public class AssinaturaController {
    private final AssinaturaMemRepository assinaturaMemRepository;
    private Logger logger = LoggerFactory.getLogger(AssinaturaController.class);
    private AssinaturaProxy assinaturaProxy;
    private CadastraAssinaturaUC cadastraAssinatura;
    private AssinaturasPorStatusUC assinaturasPorStatus;
    private ListarAssinaturasDoClienteUC listarAssinaturasDoCliente;
    private ListarAssinaturasDoAppUC listarAssinaturasDoApp;
    private VerificaAssinaturaUC verificaAssinatura;
    private Environment environment;

    @Autowired
    public AssinaturaController(CadastraAssinaturaUC cadastraAssinatura,
                                AssinaturasPorStatusUC assinaturasPorStatus,
                                ListarAssinaturasDoClienteUC listarAssinaturasDoCliente,
                                ListarAssinaturasDoAppUC listarAssinaturasDoApp,
                                VerificaAssinaturaUC verificaAssinatura, AssinaturaProxy assinaturaProxy, AssinaturaMemRepository assinaturaMemRepository) {
        this.cadastraAssinatura = cadastraAssinatura;
        this.assinaturasPorStatus = assinaturasPorStatus;
        this.listarAssinaturasDoCliente = listarAssinaturasDoCliente;
        this.listarAssinaturasDoApp = listarAssinaturasDoApp;
        this.verificaAssinatura = verificaAssinatura;
        this.assinaturaProxy = assinaturaProxy;
        this.assinaturaMemRepository = assinaturaMemRepository;
    }

    @PostMapping("/assinaturas")
    public AssinaturaDTO cadastraAssinatura(@RequestBody CodigosDTO codigosDTO){
        return cadastraAssinatura.run(codigosDTO.getCodcli(), codigosDTO.getCodapp());
    }

    @GetMapping("/assinaturas/{statusAssinaturaString}")
    public List<AssinaturaDTO> assinaturasPorStatus(@PathVariable String statusAssinaturaString){
        return assinaturasPorStatus.run(statusAssinaturaString);
    }

    @GetMapping("/asscli/{codcli}")
    public List<AssinaturaDTO> listarAssinaturasDoCliente(@PathVariable long codcli){
        return listarAssinaturasDoCliente.run(codcli);
    }

    @GetMapping("/assapp/{codapp}")
    public List<AssinaturaDTO> listarAssinaturasDoApp(@PathVariable long codapp){
        return listarAssinaturasDoApp.run(codapp);
    }

    @GetMapping("/invalidaass/{codass}")
    public boolean verificaAssinatura(@PathVariable long codass){
        logger.info("Verifica assinatura chamado de {}",codass);
        AssinaturaModel assinaturaModel = assinaturaMemRepository.buscaAssinaturaPorCodigo(codass);
        if(assinaturaModel == null){
            System.out.println("codass "+ codass + " not found");
            return false;
        }
//        String port = environment.getProperty("local.server.port");
//        assinaturaModel

        return assinaturaProxy.verificaAssinatura(codass);
    }
}
