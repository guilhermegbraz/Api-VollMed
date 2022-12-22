package med.voll.api.controller;

import med.voll.api.controller.model.dto.MedicoDTO;
import med.voll.api.dataprovider.entities.MedicoEntity;
import med.voll.api.dataprovider.medico.JpaMedicoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    JpaMedicoDAO jpaMedicoRepository;

    @PostMapping
    public void Cadastrar(@RequestBody MedicoDTO jsonMedico) {
        MedicoEntity md = new MedicoEntity(jsonMedico.toMedico());
        jpaMedicoRepository.save(md);
        System.out.println(jsonMedico);
    }
}
