package com.grupo5.monolitoclean.domain.repository;

import com.grupo5.monolitoclean.domain.entities.AssinaturaModel;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IAssinaturaRepository {
    AssinaturaModel registrarAssinatura(long codcli, long codapp);
    List<AssinaturaModel> listarAssinaturas();
    List<AssinaturaModel> listarAssinaturasPorCodCliente(long codigoDoCliente);
    List<AssinaturaModel> listarAssinaturasPorCodAplicativo(long codigoDoAplicativo);
    AssinaturaModel buscaAssinaturaPorCodigo(long codigoDaAssinatura);
}
