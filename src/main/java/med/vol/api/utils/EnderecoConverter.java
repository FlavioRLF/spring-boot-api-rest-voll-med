package med.vol.api.utils;

import med.vol.api.dtos.EnderecoDTO;
import med.vol.api.models.entity.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoConverter {

    public Endereco enderecoDtoToEntity(EnderecoDTO enderecoDto) {

        Endereco endereco = new Endereco();

        endereco.setUf(enderecoDto.getUf());
        endereco.setCep(enderecoDto.getCep());
        endereco.setLogradouro(enderecoDto.getLogradouro());
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setComplemento(enderecoDto.getComplemento());
        endereco.setBairro(enderecoDto.getBairro());
        endereco.setCidade(enderecoDto.getCidade());

        return endereco;
    }
}
