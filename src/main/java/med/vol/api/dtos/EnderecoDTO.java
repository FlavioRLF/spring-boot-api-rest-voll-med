package med.vol.api.dtos;

import lombok.*;

import java.io.Serializable;

@Data
public class EnderecoDTO implements Serializable {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
}
