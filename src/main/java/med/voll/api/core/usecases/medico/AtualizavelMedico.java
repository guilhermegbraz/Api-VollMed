package med.voll.api.core.usecases.medico;

import med.voll.api.core.entities.Endereco;

public interface AtualizavelMedico {

    Long getId();
    String getNome();
    String getTelefone();
    Endereco getEndereco();
}
