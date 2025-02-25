package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa_fisica")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends PessoaFisica {
    private String contato;
    private boolean ativo;

}

