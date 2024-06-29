package com.grupo5.monolitoclean.domain.services;

import com.grupo5.monolitoclean.domain.entities.PagamentoModel;
import com.grupo5.monolitoclean.domain.repository.IAplicativoRepository;
import com.grupo5.monolitoclean.domain.repository.IAssinaturaRepository;
import com.grupo5.monolitoclean.domain.repository.IPagamentoRepository;
import com.grupo5.monolitoclean.application.dtos.PagamentoDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class PagamentoService {
    private IPagamentoRepository pagamentoRepository;
    private IAssinaturaRepository assinaturaRepository;


    public PagamentoService(IPagamentoRepository pagamentoRepository, IAssinaturaRepository assinaturaRepository){
        this.pagamentoRepository = pagamentoRepository;
        this.assinaturaRepository = assinaturaRepository;
    }


    public PagamentoModel registraPagamento(PagamentoDTO pagamentoDTO) {
        PagamentoModel pagamento = new PagamentoModel(
                pagamentoRepository.quantidadeDePagamentosRegistrados(),
                assinaturaRepository.buscaAssinaturaPorCodigo(pagamentoDTO.codass()),
                pagamentoDTO.valorPago(),
                LocalDateTime.of(
                        pagamentoDTO.ano(),
                        pagamentoDTO.mes(),
                        pagamentoDTO.dia(),
                        0,
                        0
                ),
                "none"
        );
        return pagamentoRepository.registrarPagamento(pagamento);
    }
}
