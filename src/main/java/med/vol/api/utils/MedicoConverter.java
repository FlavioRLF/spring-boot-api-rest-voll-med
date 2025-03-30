package med.vol.api.utils;

import med.vol.api.dtos.request.CadastraMedicoRequestDTO;
import med.vol.api.models.entity.Medico;
import med.vol.api.models.enums.EnumEspecialidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConverter {

    @Autowired
    private EnderecoConverter enderecoConverter;

    public Medico cadastroDtoToEntity(CadastraMedicoRequestDTO requisicao) {
        return Medico.builder()
                .crm(requisicao.getCrm())
                .email(requisicao.getEmail())
                .nome(requisicao.getNome())
                .endereco(enderecoConverter.enderecoDtoToEntity(requisicao.getEndereco()))
                .especialidade(EnumEspecialidade.valueOf(requisicao.getEspecialidade()))
                .telefone(requisicao.getTelefone())
                .build();
    }
}
