package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "filial")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String telefone;

}

