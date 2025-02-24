package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Frete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroNotaFiscal;
    private BigDecimal valorKmRodado;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "cidade_origem_id", nullable = false)
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "cidade_destino_id", nullable = false)
    private Cidade cidadeDestino;

    @ManyToOne
    @JoinColumn(name = "categoria_frete_id", nullable = false)
    private CategoriaFrete categoriaFrete;

    @OneToMany
    @JoinColumn(name = "frete_id")
    private List<ItemFrete> itens;

    public BigDecimal calcularFrete() {
        BigDecimal distancia = BigDecimal.valueOf(new Distancia().getQuilometros());
        BigDecimal percentual = BigDecimal.valueOf(categoriaFrete.getPercentualAdicional()).divide(BigDecimal.valueOf(100));
        return valorKmRodado.multiply(distancia).multiply(BigDecimal.ONE.add(percentual));
    }

}
