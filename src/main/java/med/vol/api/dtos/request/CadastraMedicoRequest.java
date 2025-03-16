package med.vol.api.dtos.request;

import lombok.*;
import med.vol.api.dtos.EnderecoDTO;

import java.io.Serializable;

@Data
@Builder
public class CadastraMedicoRequest implements Serializable {

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    private String especialidade;

    private EnderecoDTO endereco;
}
