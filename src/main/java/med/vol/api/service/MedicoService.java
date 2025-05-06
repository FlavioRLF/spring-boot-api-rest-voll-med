package med.vol.api.service;

import med.vol.api.dtos.MedicoDTO;
import med.vol.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<MedicoDTO> buscarTodosDTOs() {
        List<Object[]> resultados = medicoRepository.findMedicosRaw();
        return resultados.stream()
                .map(obj -> new MedicoDTO(
                        ((Number) obj[0]).longValue(),
                        (String) obj[1],
                        (String) obj[2],
                        (String) obj[3],
                        (String) obj[4]
                ))
                .toList();
    }
}
