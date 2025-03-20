package med.vol.api.controllers;

import med.vol.api.dtos.request.CadastraMedicoRequestDTO;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private static final Logger logger = LoggerFactory.getLogger(MedicoController.class);

    @PostMapping
    public Integer cadastraMedico(@RequestBody final CadastraMedicoRequestDTO requisicao) {
        logger.info("DADOS DA REQUISICAO ID = " + requisicao.toString());
        return Response.SC_OK;
    }
}
