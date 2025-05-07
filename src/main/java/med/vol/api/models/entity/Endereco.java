package med.vol.api.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import med.vol.api.dtos.EnderecoDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    public void atualizaEndereco(EnderecoDTO endereco) {

        if(endereco.getLogradouro() != null) {
            this.logradouro = endereco.getLogradouro();
        }

        if(endereco.getBairro() != null) {
            this.bairro = endereco.getBairro();
        }

        if(endereco.getCep() != null) {
            this.cep = endereco.getCep();
        }

        if(endereco.getNumero() != null) {
            this.numero = endereco.getNumero();
        }

        if(endereco.getComplemento() != null) {
            this.complemento = endereco.getComplemento();
        }

        if(endereco.getCidade() != null) {
            this.cidade = endereco.getCidade();
        }

        if(endereco.getUf() != null) {
            this.uf = endereco.getUf();
        }
    }
}
