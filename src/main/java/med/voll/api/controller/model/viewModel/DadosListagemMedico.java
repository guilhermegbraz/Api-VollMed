package med.voll.api.controller.model.viewModel;


import med.voll.api.core.entities.medico.Especialidade;
import med.voll.api.dataprovider.entities.MedicoEntity;

import java.util.Locale;


public record DadosListagemMedico(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(MedicoEntity medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCRM(), medico.getEspecialidade());
    }

}
