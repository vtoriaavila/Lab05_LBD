package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa_fisica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends PessoaFisica {

    private int matricula;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;

}

