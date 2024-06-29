package com.grupo5.monolitoclean.application.dtos;

import com.grupo5.monolitoclean.domain.entities.ClienteModel;

public record ClienteDTO(
        long codigo,
        String nome,
        String email
) {
    public static ClienteDTO fromModel(ClienteModel cliente) {
        return new ClienteDTO(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }
}
