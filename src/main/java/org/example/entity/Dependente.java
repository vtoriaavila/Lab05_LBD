package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name="dependente")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dependente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name="id_funcionario", nullable = false)
    private Funcionario funcionario;
}
