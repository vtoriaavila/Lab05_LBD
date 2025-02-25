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
            return null;
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
