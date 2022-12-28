package med.voll.api.core.entities.medico;

public interface MedicoRepository {

    void cadastrar(Medico novoMedico);

    Medico recuperarUmMedico(Long id);

    void atualizar(Medico medicoAtualizado);
}
