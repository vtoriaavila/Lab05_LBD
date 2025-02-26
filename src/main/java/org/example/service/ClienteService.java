package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.entity.Frete;
import org.example.repository.FreteRepository;

import java.util.List;

public class ClienteService {
    FreteRepository freteRepository;

    public ClienteService(EntityManager entityManager) {
        this.freteRepository = new FreteRepository(entityManager);
    }

    public List<Frete> listarFretesPorCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente deve ser informado.");
        }
        if (cliente.getId() == 0) {
            throw new IllegalArgumentException("O ID do cliente é inválido.");
        }

        return freteRepository.buscarPorCliente(cliente.getId());
    }
}
