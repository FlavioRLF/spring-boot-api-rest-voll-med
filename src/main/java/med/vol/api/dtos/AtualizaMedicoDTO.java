package med.vol.api.dtos;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.NonNull;

@Data
public class AtualizaMedicoDTO {

    @NonNull
    private Long id;

    private String nome;

    private String telefone;

    @Valid
    private EnderecoDTO endereco;
}
