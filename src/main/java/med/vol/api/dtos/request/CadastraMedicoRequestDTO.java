package med.vol.api.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import med.vol.api.dtos.EnderecoDTO;

import java.io.Serializable;

@Data
@Builder
public class CadastraMedicoRequestDTO implements Serializable {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

    @NonNull
    @Pattern(regexp = "\\d{4,6}")
    private String crm;

    @NotBlank
    private String especialidade;

    @NotNull
    @Valid
    private EnderecoDTO endereco;
}
