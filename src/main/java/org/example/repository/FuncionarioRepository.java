package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Funcionario;

public class FuncionarioRepository extends GenericDAO<Funcionario> {
    public FuncionarioRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
