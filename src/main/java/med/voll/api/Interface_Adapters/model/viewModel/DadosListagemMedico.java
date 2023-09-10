package med.voll.api.Interface_Adapters.model.viewModel;


import med.voll.api.core.entities.medico.Especialidade;
import med.voll.api.dataprovider.entities.MedicoEntity;



public record DadosListagemMedico(Long id,String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(MedicoEntity medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCRM(), medico.getEspecialidade());
    }

}
