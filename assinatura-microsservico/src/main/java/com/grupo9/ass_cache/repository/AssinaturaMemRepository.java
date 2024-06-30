package com.grupo9.ass_cache.repository;

import com.grupo9.ass_cache.domain.entities.AssinaturaModel;
import com.grupo9.ass_cache.domain.repository.IAssinaturaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AssinaturaMemRepository implements IAssinaturaRepository {
    private List<AssinaturaModel> assinaturas;


    public AssinaturaMemRepository(){
        this.assinaturas = new ArrayList<>();
    }

    @Override
    public AssinaturaModel buscaAssinaturaPorCodigo(long codigoDaAssinatura){
        for (AssinaturaModel aux:assinaturas) {
            if (aux.getCodigo() == codigoDaAssinatura){
                return aux;
            }
        }
        return null;
    }
}
