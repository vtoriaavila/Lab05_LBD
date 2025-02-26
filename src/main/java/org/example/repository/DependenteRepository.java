package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Dependente;

public class DependenteRepository extends GenericDAO<Dependente> {
    public DependenteRepository(EntityManager entityManager) {
        super(entityManager);
    }
}

