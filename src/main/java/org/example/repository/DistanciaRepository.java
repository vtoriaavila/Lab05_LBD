package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.entity.Distancia;

public class DistanciaRepository extends GenericDAO<Distancia> {
    public DistanciaRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Distancia buscarPorCidades(Long origemId, Long destinoId) {
        try {
            return entityManager.createQuery(
                            "SELECT d FROM Distancia d WHERE d.origem.id = :origemId AND d.destino.id = :destinoId",
                            Distancia.class
                    )
                    .setParameter("origemId", origemId)
                    .setParameter("destinoId", destinoId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Se não encontrar a distância, retorna null em vez de lançar erro
        }
    }

    public double calcularDistancia(Long idOrigem, Long idDestino) {
        Distancia distancia = buscarPorCidades(idOrigem, idDestino);

        if (distancia != null) {
            return distancia.getQuilometros();
        } else {
            System.out.println("Distância entre as cidades não encontrada.");
            return -1; // Pode ser alterado para lançar uma exceção ou retornar um valor padrão
        }
    }

}
