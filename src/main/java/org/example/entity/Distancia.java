package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Distancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origem_id")
    private Cidade origem;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Cidade destino;

    private int quilometros;

}

