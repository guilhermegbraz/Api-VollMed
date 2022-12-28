package med.voll.api.core.usecases.medico;


import med.voll.api.core.entities.BusinessException;
import med.voll.api.core.entities.medico.Medico;
import med.voll.api.core.entities.medico.MedicoRepository;
import med.voll.api.core.usecases.validação.medico.ValidadorCadastroMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroDeMedico {

    @Autowired
    MedicoRepository repositorio;

    @Autowired
    List<ValidadorCadastroMedico> validacoes;

    public CadastroDeMedico(MedicoRepository medicoRepository, List<ValidadorCadastroMedico> v) {
        this.repositorio = medicoRepository;
        this.validacoes = v;
    }

    public void executar(Medico novoMedico) throws BusinessException {
        try {
            this.validacoes.forEach(validacao -> validacao.validar(novoMedico));
            this.repositorio.cadastrar(novoMedico);
        }catch (BusinessException exception) {
            throw exception;
        }
    }

}
