package med.vol.api.dtos;

import lombok.*;

import java.io.Serializable;

@Data
public class EnderecoDTO implements Serializable {

    @NonNull
    private String logradouro;

    private String numero;

    private String complemento;

    @NonNull
    private String bairro;

    @NonNull
    private String cidade;

    @NonNull
    private String uf;

    @NonNull
    private String cep;
}
