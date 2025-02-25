package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Filial;

public class FilialRepository extends GenericDAO<Filial> {
    public FilialRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
