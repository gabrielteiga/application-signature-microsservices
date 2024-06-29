package com.grupo5.monolitoclean.domain.services;

import com.grupo5.monolitoclean.domain.entities.ClienteModel;
import com.grupo5.monolitoclean.domain.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel registrarCliente(ClienteModel clienteModel){
        return clienteRepository.registrarCliente(clienteModel);
    }


    public List<ClienteModel> clientesCadastrados(){
        return clienteRepository.listarClientes();
    }
}
