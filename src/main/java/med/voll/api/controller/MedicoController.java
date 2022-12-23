package med.voll.api.controller;

import med.voll.api.controller.model.dto.MedicoDTO;
import med.voll.api.core.entities.BusinessException;
import med.voll.api.dataprovider.entities.MedicoEntity;
import med.voll.api.dataprovider.medico.JpaMedicoRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    JpaMedicoRepository jpaMedicoRepository;

    @PostMapping
    public ResponseEntity<String> Cadastrar(@RequestBody MedicoDTO jsonMedico, Request req) {
        MedicoEntity md = new MedicoEntity(jsonMedico.toMedico());
        try{
            jpaMedicoRepository.save(md);
        }catch (BusinessException exception){
            return new ResponseEntity<>(exception.getCause() + exception.getMessage(), HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity("Medico Criado com sucesso", HttpStatus.CREATED);
    }
}
