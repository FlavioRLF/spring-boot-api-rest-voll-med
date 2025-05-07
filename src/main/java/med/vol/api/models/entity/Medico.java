package med.vol.api.models.entity;

import jakarta.persistence.*;
import lombok.*;
import med.vol.api.dtos.AtualizaMedicoDTO;
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

    @Column(name = "ativo")
    private Boolean ativo;

    public void atualizaMedico(AtualizaMedicoDTO requisicao) {
        if (requisicao.getNome() != null && !requisicao.getNome().isBlank()) {
            this.nome = requisicao.getNome();
        }
        if (requisicao.getTelefone() != null && !requisicao.getTelefone().isBlank()) {
            this.telefone = requisicao.getTelefone();
        }
        if (requisicao.getEndereco() != null) {
            this.endereco.atualizaEndereco(requisicao.getEndereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
