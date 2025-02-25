package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;

public class ClienteRepository extends GenericDAO<Cliente> {
    public ClienteRepository(EntityManager entityManager) {
        super(entityManager);
    }
}