package org.example.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.*;
import org.example.service.FreteService;

import java.math.BigDecimal;
import java.util.Optional;

public class TesteFreteService {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_LBD");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transacao = manager.getTransaction();
        transacao.begin();

        // Criando cidades
        Cidade origem = new Cidade();
        origem.setNome("São Paulo");
        manager.persist(origem);

        Cidade destino = new Cidade();
        destino.setNome("Rio de Janeiro");
        manager.persist(destino);

        // Criando e persistindo a distância entre as cidades
        Distancia distancia = new Distancia();
        distancia.setOrigem(origem);
        distancia.setDestino(destino);
        distancia.setQuilometros(400); // Supondo que seja 400 km de SP ao RJ
        manager.persist(distancia);

        // Criando categoria de frete
        CategoriaFrete categoriaFrete = new CategoriaFrete();
        categoriaFrete.setPercentualAdicional(10);
        manager.persist(categoriaFrete);

        // Criando e persistindo um cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Empresa X");
        cliente.setCpf("123.456.789-00"); // Exemplo de CPF corrigido
        manager.persist(cliente);

        // Criando e persistindo um tipo de veículo
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setDescricao("Caminhão");
        tipoVeiculo.setPesoMaximo(20.0F);
        manager.persist(tipoVeiculo); // Necessário persistir antes de referenciar

        // Criando e persistindo uma filial
        Filial filial = new Filial();
        filial.setNome("Filial Central");
        manager.persist(filial);


        // Criando e persistindo um veículo
        Veiculo veiculo = new Veiculo();
        veiculo.setNumeroPlaca("ABC-1234");
        veiculo.setTipoVeiculo(tipoVeiculo);
        veiculo.setFilial(filial);// Agora o tipoVeiculo já está persistido
        manager.persist(veiculo);

        // Criando frete
        Frete frete = new Frete();
        frete.setCidadeOrigem(origem);
        frete.setCidadeDestino(destino);
        frete.setValorKmRodado(new BigDecimal("2.50"));
        frete.setCategoriaFrete(categoriaFrete);
        frete.setCliente(cliente);
        frete.setVeiculo(veiculo);

        manager.persist(frete); // Persistindo o frete antes de registrar no service

        transacao.commit();

        // Criando o service e registrando o frete
        FreteService freteService = new FreteService(manager);
        freteService.registrarFrete(frete);

        // Buscar frete por ID
        Frete freteEncontrado = freteService.buscarFretePorId(frete.getId());

        System.out.println(freteEncontrado.toString());

//        // Verificar se o frete foi encontrado e imprimir informações
//        freteEncontrado(f -> System.out.println("Frete encontrado: " + f.getId() + " - Valor: " + f.getValorKmRodado()));

        manager.close();
        factory.close();
    }
}
