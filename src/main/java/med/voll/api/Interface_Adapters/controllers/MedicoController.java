package med.voll.api.Interface_Adapters.controllers;

import med.voll.api.Interface_Adapters.model.dto.DtoAtualizaMedico;
import med.voll.api.Interface_Adapters.model.dto.DtoCadastroMedico;
import med.voll.api.Interface_Adapters.model.viewModel.DadosListagemMedico;
import med.voll.api.core.entities.BusinessException;
import med.voll.api.core.entities.medico.Medico;
import med.voll.api.core.usecases.medico.AtualizarDadosMedico;
import med.voll.api.core.usecases.medico.CadastroDeMedico;
import med.voll.api.core.usecases.medico.DeletarMedico;
import med.voll.api.dataprovider.converters.MedicoToMedicoEntityConversor;
import med.voll.api.dataprovider.medico.JpaMedicoDAO;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class MedicoController {
    final JpaMedicoDAO jpaMedicoRepository;
    final CadastroDeMedico cadastrarMedico;
    final AtualizarDadosMedico atualizarDadosMedico;
    final DeletarMedico deletarMedico;
    final MedicoToMedicoEntityConversor conversor;

    public MedicoController(JpaMedicoDAO jpaMedicoRepository, CadastroDeMedico cadastrarMedico, AtualizarDadosMedico atualizarDadosMedico, DeletarMedico deletarMedico, MedicoToMedicoEntityConversor conversor) {
        this.jpaMedicoRepository = jpaMedicoRepository;
        this.cadastrarMedico = cadastrarMedico;
        this.atualizarDadosMedico = atualizarDadosMedico;
        this.deletarMedico = deletarMedico;
        this.conversor = conversor;
    }

    public DadosListagemMedico Cadastrar(@NotNull DtoCadastroMedico jsonMedico) {
        try{
            var medico = jsonMedico.toMedico();
            var id = (cadastrarMedico.executar(medico));
            return new DadosListagemMedico(Long.valueOf(id),
                            medico.getNome(),
                            medico.getEmail().getEndereco(),
                            medico.getCRM(),
                            medico.getEspecialidade());

        }catch (BusinessException exception){
            throw exception;
        }
    }

    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        var page = this.jpaMedicoRepository.listarTodosMedicos(paginacao)
                .map(DadosListagemMedico :: new);
        return page;
    }

    public DadosListagemMedico atualizar(DtoAtualizaMedico dadosAtualizacao) {
        Medico medico = this.atualizarDadosMedico.executar(dadosAtualizacao);
        DadosListagemMedico dadosMedico = new DadosListagemMedico(conversor.executar(medico));

        return dadosMedico;
    }

    public void deletar(Long id) {
        this.deletarMedico.executar(id);

    }
}
