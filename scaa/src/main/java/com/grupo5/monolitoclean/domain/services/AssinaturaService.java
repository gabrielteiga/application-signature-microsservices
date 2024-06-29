package com.grupo5.monolitoclean.domain.services;

import com.grupo5.monolitoclean.domain.entities.AssinaturaModel;
import com.grupo5.monolitoclean.domain.repository.IAssinaturaRepository;
import com.grupo5.monolitoclean.domain.repository.StatusAssinatura;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AssinaturaService {
    private IAssinaturaRepository assinaturaRepository;


    public AssinaturaService(IAssinaturaRepository assinaturaRepository){
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<AssinaturaModel> listarAssinaturasDoCliente(long codCliente) {
        return assinaturaRepository.listarAssinaturasPorCodCliente(codCliente);
    }

    public boolean verificaAssinatura(long codAssinatura) {
        AssinaturaModel assinaturaModel = assinaturaRepository.buscaAssinaturaPorCodigo(codAssinatura);
        if(assinaturaModel != null){
            return true;
        }
        return false;
    }

    public AssinaturaModel registraAssinatura(long codcli, long codapp) {
        return assinaturaRepository.registrarAssinatura(codcli, codapp);
    }


    public List<AssinaturaModel> listarAssinaturasPorStatus(String statusAssinaturaString) {
        String regex = "(?i)ativa";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(statusAssinaturaString);
        StatusAssinatura statusAssinatura;

        if (matcher.find()){
            statusAssinatura = StatusAssinatura.ATIVA;
        } else {
            statusAssinatura = StatusAssinatura.CANCELADA;
        }

        LocalDate dataAtual = LocalDate.now();
        List<AssinaturaModel> assinaturasAux = assinaturaRepository.listarAssinaturas();
        List<AssinaturaModel> result = new ArrayList<>();

        for (AssinaturaModel assinaturaModel : assinaturasAux) {
            boolean isAtiva = assinaturaModel.getFimVigencia().isAfter(dataAtual);
            boolean isCancelada = assinaturaModel.getFimVigencia().isBefore(dataAtual);

            if (statusAssinatura == StatusAssinatura.ATIVA && isAtiva) {
                result.add(assinaturaModel);
            } else if (statusAssinatura == StatusAssinatura.CANCELADA && isCancelada) {
                result.add(assinaturaModel);
            }
        }

        return result;
    }

    public List<AssinaturaModel> listarAssinaturasPorCodAplicativo(long codigoDoAplicativo){
        return assinaturaRepository.listarAssinaturasPorCodAplicativo(codigoDoAplicativo);
    }
}
