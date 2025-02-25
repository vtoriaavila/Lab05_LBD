package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "item_frete")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemFrete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Float peso;

    @ManyToOne
    @JoinColumn (name="frete_id", nullable = false)
    private Frete frete;
}
