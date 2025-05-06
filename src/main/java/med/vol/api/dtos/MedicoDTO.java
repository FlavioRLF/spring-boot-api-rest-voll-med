package med.vol.api.dtos;

import lombok.*;
import med.vol.api.models.entity.Medico;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {

    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String especialidade;

    public MedicoDTO(Medico medico) {
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade().name()
        );
    }
}
