package med.voll.api.core.usecases.validação.medico;


import med.voll.api.core.entities.BusinessException;
import med.voll.api.core.entities.medico.Medico;
import org.springframework.stereotype.Component;

@Component
public class ValidarNomeNotNull implements ValidadorCadastroMedico{
    @Override
    public void validar(Medico medico) {
        if(medico.getNome().isBlank() || medico.getNome() == null)
            throw new BusinessException("O atributo nome é de preenchimento obrigatorio");
    }
}
