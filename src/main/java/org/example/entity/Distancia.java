package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "distancia")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Distancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origem_id", nullable = false)
    private Cidade origem;

    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Cidade destino;

    private int quilometros;

}

