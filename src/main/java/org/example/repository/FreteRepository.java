package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Frete;

import java.util.List;

public class FreteRepository extends GenericDAO<Frete> {
    public FreteRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Frete> buscarPorCliente(Long clienteId) {
        return entityManager.createQuery("SELECT f FROM Frete f WHERE f.cliente.id = :clienteId", Frete.class)
                .setParameter("clienteId", clienteId)
                .getResultList();
    }
}
