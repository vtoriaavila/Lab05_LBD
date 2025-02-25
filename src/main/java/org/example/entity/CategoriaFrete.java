package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "categoria_frete")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaFrete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private float percentualAdicional;

}

