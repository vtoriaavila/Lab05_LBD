package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Veiculo;

public class VeiculoRepository extends GenericDAO<Veiculo> {
    public VeiculoRepository(EntityManager entityManager) {
        super(entityManager);
    }
}

