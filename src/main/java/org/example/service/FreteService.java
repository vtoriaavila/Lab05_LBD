package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Frete;
import org.example.repository.FreteRepository;
import org.example.repository.DistanciaRepository;
import org.example.entity.Distancia;

import java.math.BigDecimal;
import java.util.Optional;

public class FreteService {
    private final FreteRepository freteRepository;
    private final DistanciaRepository distanciaRepository;

    public FreteService(EntityManager entityManager) {
        this.freteRepository = new FreteRepository(entityManager);
        this.distanciaRepository = new DistanciaRepository(entityManager);
    }


    public void registrarFrete(Frete frete) {
        BigDecimal valorFrete = calcularValorFrete(frete);
        frete.setValorKmRodado(valorFrete);
        freteRepository.salvar(frete);
        System.out.println("Frete registrado com sucesso! Valor calculado: " + valorFrete);
    }


    private BigDecimal calcularValorFrete(Frete frete) {
        Distancia distancia = distanciaRepository.buscarPorCidades(
                frete.getCidadeOrigem().getId(),
                frete.getCidadeDestino().getId()
        );

        if (distancia == null) {
            throw new RuntimeException("Distância entre as cidades não encontrada.");
        }

        BigDecimal distanciaKm = BigDecimal.valueOf(distancia.getQuilometros());
        BigDecimal percentualAdicional = BigDecimal.valueOf(frete.getCategoriaFrete().getPercentualAdicional() / 100);
        BigDecimal valorBase = distanciaKm.multiply(frete.getValorKmRodado());
        BigDecimal valorTotal = valorBase.add(valorBase.multiply(percentualAdicional));

        return valorTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public Optional<Frete> buscarFretePorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID do frete deve ser maior que zero.");
        }

        return Optional.ofNullable(freteRepository.buscarPorId((long) id));
    }

}
