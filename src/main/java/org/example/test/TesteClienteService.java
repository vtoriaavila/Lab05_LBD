package org.example.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Cliente;
import org.example.entity.Frete;
import org.example.service.ClienteService;

import java.util.List;

public class TesteClienteService {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_LBD-test");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transacao = manager.getTransaction();
        transacao.begin();

        // Cenário: Criando um cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Maria Silva");
        cliente.setCpf("987.654.321-00");
        manager.persist(cliente);

        transacao.commit();

        // Criando o service
        ClienteService clienteService = new ClienteService(manager);

        // Ação: Listar fretes por cliente
        List<Frete> fretes = clienteService.listarFretesPorCliente(cliente);

        // Verificação: Imprimir fretes encontrados
        System.out.println("Fretes encontrados para o cliente " + cliente.getNome() + ": " + fretes.size());

        manager.close();
        factory.close();
    }
}

