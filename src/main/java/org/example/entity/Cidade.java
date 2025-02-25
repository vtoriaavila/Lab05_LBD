package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cidade")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(length = 4)
    private String uf;
    private String estado;

}

