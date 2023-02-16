package med.voll.api.Interface_Adapters.model.dto;

import lombok.Getter;
import lombok.Setter;
import med.voll.api.core.entities.Endereco;
import med.voll.api.core.usecases.medico.AtualizavelMedico;

@Getter
@Setter
public final class DtoAtualizaMedico implements AtualizavelMedico {

    Long id;
    String nome;
    String telefone;
    EnderecoDTO endereco;

    public Endereco getEndereco() {
        return endereco == null ? null:endereco.toEndereco();
    }
}

