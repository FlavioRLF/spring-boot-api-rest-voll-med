package med.vol.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.dtos.AtualizaMedicoDTO;
import med.vol.api.dtos.MedicoDTO;
import med.vol.api.dtos.request.CadastraMedicoRequestDTO;
import med.vol.api.models.entity.Medico;
import med.vol.api.repository.MedicoRepository;
import med.vol.api.service.MedicoService;
import med.vol.api.utils.EnderecoConverter;
import med.vol.api.utils.MedicoConverter;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private static final Logger logger = LoggerFactory.getLogger(MedicoController.class);

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoConverter medicoConverter;

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private EnderecoConverter enderecoConverter;

    @PostMapping
    @Transactional
    public Integer cadastraMedico(@RequestBody @Valid final CadastraMedicoRequestDTO requisicao) {
        logger.info("DADOS DA REQUISICAO ID = {}", requisicao.toString());
        final Medico medico = medicoConverter.cadastroDtoToEntity(requisicao);
        medicoRepository.save(medico);
        return Response.SC_OK;
    }

    @GetMapping("/lista")
    public List<Medico> listaMedicos(){
        return medicoRepository.findAll();
    }

    @GetMapping("/dto")
    public List<MedicoDTO> listaMedicosDTO() {
        return medicoService.buscarTodosDTOs();
    }

    @GetMapping("/paginacao/dto")
    public Page<MedicoDTO> listaMedicosMapToDTO(@PageableDefault(size=5, sort = {"nome"}) Pageable pageable) {
        return medicoRepository.findAll(pageable).map(MedicoDTO::new);
    }


    @PutMapping("/atualiza")
    @Transactional
    public void atualiza(@RequestBody @Valid AtualizaMedicoDTO requisicao) {
        var medico = medicoRepository.findById(requisicao.getId()).orElseThrow(() ->
            new IllegalArgumentException("Médico com ID " + requisicao.getId() + " não encontrado.")
        );
        medico.atualizaMedico(requisicao);
    }
}
