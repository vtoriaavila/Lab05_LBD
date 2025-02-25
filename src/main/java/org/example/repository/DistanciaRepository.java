package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Distancia;

public class DistanciaRepository extends GenericDAO<Distancia> {
    public DistanciaRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Distancia buscarPorCidades(Long idOrigem, Long idDestino) {
        try {
            return entityManager.createQuery(
                            "SELECT d FROM Distancia d WHERE d.cidadeOrigem.id = :idOrigem AND d.cidadeDestino.id = :idDestino",
                            Distancia.class)
                    .setParameter("idOrigem", idOrigem)
                    .setParameter("idDestino", idDestino)
                    .getSingleResult();
        } catch (Exception e) {
            return null;  // Se não encontrar, retorna null
        }
    }
}
