package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="tipo_veiculo")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Float pesoMaximo;

}

