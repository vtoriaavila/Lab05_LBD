package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="veiculo")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroPlaca;

    @ManyToOne
    @JoinColumn(name = "filial_id", nullable = false)
    private Filial filial;

    @ManyToOne
    @JoinColumn(name = "tipo_veiculo_id", nullable = false)
    private TipoVeiculo tipoVeiculo;

}
