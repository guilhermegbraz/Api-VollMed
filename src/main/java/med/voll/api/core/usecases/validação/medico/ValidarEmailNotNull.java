package med.voll.api.core.usecases.validação.medico;


import med.voll.api.core.entities.BusinessException;
import med.voll.api.core.entities.medico.Medico;


public class ValidarEmailNotNull implements ValidadorCadastroMedico{

    @Override
    public void validar(Medico medico) {
       if (medico.getEmail().getEndereco() == null ||
               medico.getEmail().getEndereco().isBlank())
           throw new BusinessException("O atributo e-mail é de preenchimento obrigatório");
    }
}
