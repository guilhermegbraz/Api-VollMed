package med.voll.api.controller;

import med.voll.api.controller.model.dto.DtoAtualizaMedico;
import med.voll.api.controller.model.dto.DtoCadastroMedico;
import med.voll.api.controller.model.viewModel.DadosListagemMedico;
import med.voll.api.core.entities.BusinessException;
import med.voll.api.core.usecases.medico.AtualizarDadosMedico;
import med.voll.api.core.usecases.medico.CadastroDeMedico;
import med.voll.api.dataprovider.medico.JpaMedicoDAO;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    JpaMedicoDAO jpaMedicoRepository;

    @Autowired
    CadastroDeMedico cadastrarMedico;

    @Autowired
    AtualizarDadosMedico atualizarDadosMedico;

    @PostMapping
    @Transactional
    public ResponseEntity Cadastrar(@RequestBody DtoCadastroMedico jsonMedico, Request req) {
        try{
            cadastrarMedico.executar(jsonMedico.toMedico());
        }catch (BusinessException exception){
            System.out.println(exception.getMessage());
            return ResponseEntity.ok(exception.getMessage());
        }
        return ResponseEntity.ok("Médico Cadastrado");
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = "nome") Pageable paginacao) {

        return this.jpaMedicoRepository.listarTodosMedicos(paginacao).map(DadosListagemMedico :: new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DtoAtualizaMedico dadosAtualizacao) {

        this.atualizarDadosMedico.executar(dadosAtualizacao);
    }
}
