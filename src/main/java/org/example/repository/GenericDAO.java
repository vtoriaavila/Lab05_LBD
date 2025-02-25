package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public abstract class GenericDAO<T> {
    protected EntityManager entityManager;
    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityClass = entityClass ;
    }

    public void salvar(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void atualizar(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            T entity = entityManager.find(entityClass, id);
            if (entity != null) {
                entityManager.remove(entity);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public T buscarPorId(Long id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> listarTodos() {
        return entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass)
                .getResultList();
    }
}

