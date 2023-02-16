package med.voll.api.core.usecases.medico;


import med.voll.api.core.entities.BusinessException;
import med.voll.api.core.entities.medico.Medico;
import med.voll.api.core.entities.medico.MedicoRepository;
import med.voll.api.core.usecases.validação.medico.ValidadorCadastroMedico;
import java.util.List;


public class CadastroDeMedico {

    private final MedicoRepository repositorio;
    private final List<ValidadorCadastroMedico> validacoes;

    public CadastroDeMedico(MedicoRepository medicoRepository, List<ValidadorCadastroMedico> v) {
        this.repositorio = medicoRepository;
        this.validacoes = v;
    }

    public String executar(Medico novoMedico) throws BusinessException {
        try {
            this.validacoes.forEach(validacao -> validacao.validar(novoMedico));
            var id = this.repositorio.cadastrar(novoMedico);
            return id;
        }catch (BusinessException exception) {
            throw exception;
        }
    }

}
