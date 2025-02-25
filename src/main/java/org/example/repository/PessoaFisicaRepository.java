package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.PessoaFisica;

public class PessoaFisicaRepository extends GenericDAO<PessoaFisica> {
    public PessoaFisicaRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
