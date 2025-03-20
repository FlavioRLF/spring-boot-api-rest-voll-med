package med.vol.api.dtos.request;

import lombok.*;
import med.vol.api.dtos.EnderecoDTO;

import java.io.Serializable;

@Data
@Builder
public class CadastraMedicoRequestDTO implements Serializable {

    @NonNull
    private String nome;

    @NonNull
    private String email;

    @NonNull
    private String telefone;

    @NonNull
    private String crm;

    @NonNull
    private String especialidade;

    private EnderecoDTO endereco;
}
