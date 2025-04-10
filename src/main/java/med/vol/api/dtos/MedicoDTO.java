package med.vol.api.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {

    private Long id;
    private String nome;
    private String email;
    private String especialidade;
}
