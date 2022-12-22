package med.voll.api.core.usecases.validação.medico;


import med.voll.api.core.entities.medico.Medico;

public interface ValidadorCadastroMedico {

    void validar(Medico medico);
}
