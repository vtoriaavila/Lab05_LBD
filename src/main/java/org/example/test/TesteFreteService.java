package org.example.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Frete;
import org.example.entity.Cidade;
import org.example.entity.CategoriaFrete;
import org.example.service.FreteService;

import java.math.BigDecimal;
import java.util.Optional;

public class TesteFreteService {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_LBD-test");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transacao = manager.getTransaction();
        transacao.begin();

        // Cenário: Criando cidades e categoria de frete
        Cidade origem = new Cidade();
        origem.setNome("São Paulo");
        manager.persist(origem);

        Cidade destino = new Cidade();
        destino.setNome("Rio de Janeiro");
        manager.persist(destino);

        CategoriaFrete categoriaFrete = new CategoriaFrete();
        categoriaFrete.setPercentualAdicional(10);
        manager.persist(categoriaFrete);

        // Criando frete
        Frete frete = new Frete();
        frete.setCidadeOrigem(origem);
        frete.setCidadeDestino(destino);
        frete.setValorKmRodado(new BigDecimal("2.50"));
        frete.setCategoriaFrete(categoriaFrete);

        transacao.commit();

        // Criando o service
        FreteService freteService = new FreteService(manager);

        // Ação: Registrar o frete
        transacao.begin();
        freteService.registrarFrete(frete);
        transacao.commit();

        // Ação: Buscar frete por ID
        Optional<Frete> freteEncontrado = freteService.buscarFretePorId(frete.getId().intValue());

        // Verificação: Imprimir informações do frete encontrado
        freteEncontrado.ifPresent(f -> System.out.println("Frete encontrado: " + f.getId() + " - Valor: " + f.getValorKmRodado()));

        manager.close();
        factory.close();
    }
}
