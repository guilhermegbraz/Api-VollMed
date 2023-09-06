package med.voll.api.entryponit.api_rest.controller;

import med.voll.api.Interface_Adapters.controllers.MedicoController;
import med.voll.api.Interface_Adapters.model.dto.DtoAtualizaMedico;
import med.voll.api.Interface_Adapters.model.dto.DtoCadastroMedico;
import med.voll.api.Interface_Adapters.model.viewModel.DadosListagemMedico;
import med.voll.api.core.entities.BusinessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medico")
public class ApiMedicoController {

    private final MedicoController medicoController;

    public ApiMedicoController(MedicoController medicoController) {
        this.medicoController = medicoController;
    }

    @PostMapping
    @Transactional
    public ResponseEntity Cadastrar(@RequestBody DtoCadastroMedico jsonMedico, UriComponentsBuilder uriBuilder) {
        try{
            var medicoCadastrado = this.medicoController.Cadastrar(jsonMedico);
            var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medicoCadastrado.id()).toUri();

            return ResponseEntity.created(uri).body(medicoCadastrado);
        }catch (BusinessException exception){
            return ResponseEntity.ok(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = "nome") Pageable paginacao) {
        var page = this.medicoController.listar(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemMedico> atualizar(@RequestBody DtoAtualizaMedico dadosAtualizacao) {
        var medicoAtualizado = this.medicoController.atualizar(dadosAtualizacao);

        return ResponseEntity.ok(medicoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.medicoController.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
