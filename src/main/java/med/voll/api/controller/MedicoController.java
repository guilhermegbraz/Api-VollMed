package med.voll.api.controller;

import med.voll.api.controller.model.dto.MedicoDTO;
import med.voll.api.controller.model.viewModel.DadosListagemMedico;
import med.voll.api.core.entities.BusinessException;
import med.voll.api.dataprovider.medico.JpaMedicoDAO;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    JpaMedicoDAO jpaMedicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> Cadastrar(@RequestBody MedicoDTO jsonMedico, Request req) {
        try{
            jpaMedicoRepository.cadastrar(jsonMedico.toMedico());
        }catch (BusinessException exception){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    exception.getLocalizedMessage(),exception );
        }
        return ResponseEntity.ok("Médico Cadastrado");
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = "nome") Pageable paginacao) {

        return this.jpaMedicoRepository.listarTodosMedicos(paginacao).map(DadosListagemMedico :: new);
    }
}
