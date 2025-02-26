package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.CategoriaFrete;

public class CategoriaFreteRepository extends GenericDAO<CategoriaFrete> {
    public CategoriaFreteRepository(EntityManager entityManager) {
        super(entityManager);
    }
}

