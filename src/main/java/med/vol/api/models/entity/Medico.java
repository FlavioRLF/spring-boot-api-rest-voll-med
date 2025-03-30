package med.vol.api.models.entity;

import jakarta.persistence.*;
import lombok.*;
import med.vol.api.models.enums.EnumEspecialidade;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Builder
@Table(name = "medicos")
public class Medico implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "crm")
    private String crm;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade")
    private EnumEspecialidade especialidade;

    @Embedded
    private Endereco endereco;
}
