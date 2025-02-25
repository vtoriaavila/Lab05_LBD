package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.TipoVeiculo;

public class TipoVeiculoRepository extends GenericDAO<TipoVeiculo> {
    public TipoVeiculoRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
