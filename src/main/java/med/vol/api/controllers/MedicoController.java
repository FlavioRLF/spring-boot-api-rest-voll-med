package med.vol.api.controllers;

import med.vol.api.dtos.request.CadastraMedicoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private static final Logger logger = LoggerFactory.getLogger(MedicoController.class);

    @PostMapping
    public void cadastraMedico(@RequestBody final CadastraMedicoRequest requisicao) {
        logger.info("DADOS DA REQUISICAO ID = " + requisicao.toString());
    }
}
