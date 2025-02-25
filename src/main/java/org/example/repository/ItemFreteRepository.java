package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.ItemFrete;

public class ItemFreteRepository extends GenericDAO<ItemFrete> {
    public ItemFreteRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
