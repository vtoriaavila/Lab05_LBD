package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cliente")
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@PrimaryKeyJoinColumn(name = "id_pessoa_fisica")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends PessoaFisica {
    private String contato;
    private boolean ativo;

}

