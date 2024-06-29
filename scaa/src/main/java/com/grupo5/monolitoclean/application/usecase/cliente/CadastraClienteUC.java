package com.grupo5.monolitoclean.application.usecase.cliente;

import com.grupo5.monolitoclean.application.dtos.ClienteDTO;
import com.grupo5.monolitoclean.domain.entities.ClienteModel;
import com.grupo5.monolitoclean.domain.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraClienteUC {
    private ClienteService cadastraCliente;

    @Autowired
    public CadastraClienteUC(ClienteService cadastraCliente) {
        this.cadastraCliente = cadastraCliente;
    }

    public ClienteDTO run(ClienteModel clienteModel) {
        ClienteModel cliente = cadastraCliente.registrarCliente(clienteModel);
        return ClienteDTO.fromModel(cliente);
    }
}
