package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Cidade;

public class CidadeRepository extends GenericDAO<Cidade> {
    public CidadeRepository(EntityManager entityManager) {
        super(entityManager);
    }
}

