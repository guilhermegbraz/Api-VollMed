package med.voll.api.core.usecases.medico;

import med.voll.api.core.entities.medico.Medico;
import med.voll.api.core.entities.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarMedico {

    @Autowired
    private MedicoRepository medicoRepository;

    public void executar(Long id) {
        Medico medicoExcluir = this.medicoRepository.recuperarUmMedico(id);
        medicoExcluir.setAtivo(false);
        this.medicoRepository.deletar(medicoExcluir);
    }
}
