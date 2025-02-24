package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Funcionario extends PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int matricula;

    @OneToOne
    @JoinColumn(name = "pessoaFisica_id")
    private PessoaFisica pessoaFisica;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;

    @OneToMany
    @JoinColumn(name = "dependente_id")
    private List<Dependente> dependentes;
}

