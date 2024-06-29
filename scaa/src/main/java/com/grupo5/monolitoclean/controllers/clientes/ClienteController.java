package com.grupo5.monolitoclean.controllers.clientes;

import com.grupo5.monolitoclean.application.dtos.ClienteDTO;
import com.grupo5.monolitoclean.application.usecase.cliente.ClientesCadastradosUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servcad/clientes")
public class ClienteController {
    private ClientesCadastradosUC clientesCadastrados;

    @Autowired
    public ClienteController(ClientesCadastradosUC clientesCadastrados) {
        this.clientesCadastrados = clientesCadastrados;
    }

    @GetMapping("")
    public List<ClienteDTO> clientesCadastrados(){
        return clientesCadastrados.run();
    }
}
