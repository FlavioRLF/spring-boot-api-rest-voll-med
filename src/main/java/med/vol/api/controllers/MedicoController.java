package med.vol.api.controllers;

import jakarta.transaction.Transactional;
import med.vol.api.dtos.request.CadastraMedicoRequestDTO;
import med.vol.api.models.entity.Medico;
import med.vol.api.repository.MedicoRepository;
import med.vol.api.utils.MedicoConverter;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private static final Logger logger = LoggerFactory.getLogger(MedicoController.class);

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoConverter medicoConverter;


    @PostMapping
    @Transactional
    public Integer cadastraMedico(@RequestBody final CadastraMedicoRequestDTO requisicao) {
        logger.info("DADOS DA REQUISICAO ID = {}", requisicao.toString());
        final Medico medico = medicoConverter.cadastroDtoToEntity(requisicao);
        medicoRepository.save(medico);
        return Response.SC_OK;
    }
}
