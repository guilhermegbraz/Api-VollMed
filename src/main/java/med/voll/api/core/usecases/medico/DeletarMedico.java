package med.voll.api.core.usecases.medico;

import med.voll.api.core.entities.medico.Medico;
import med.voll.api.core.entities.medico.MedicoRepository;


public class DeletarMedico {


    private final MedicoRepository medicoRepository;

    public DeletarMedico(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void executar(Long id) {
        Medico medicoExcluir = this.medicoRepository.recuperarUmMedico(id);
        medicoExcluir.setAtivo(false);
        this.medicoRepository.deletar(medicoExcluir);
    }
}
