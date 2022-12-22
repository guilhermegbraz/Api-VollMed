package med.voll.api.controller.model.dto;


import med.voll.api.core.entities.BusinessException;
import med.voll.api.core.entities.Email;
import med.voll.api.core.entities.medico.Especialidade;
import med.voll.api.core.entities.medico.Medico;

public record MedicoDTO(String nome, String email, String CRM,
                        Especialidade especialidade, EnderecoDTO endereco) {
    public Medico toMedico() {
        try {
        return new
                Medico(this.nome,
                new Email(this.email),
                this.CRM,
                this.especialidade,
                endereco.toEndereco());
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
