package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cliente extends PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contato;
    private boolean ativo;

    @OneToOne
    @JoinColumn(name = "pessoaFisica_id")
    private PessoaFisica pessoaFisica;


}

