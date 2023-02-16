package med.voll.api.core.entities.medico;

public interface MedicoRepository {

    String cadastrar(Medico novoMedico);

    Medico recuperarUmMedico(Long id);

    void atualizar(Medico medicoAtualizado);

    void deletar(Medico medico);
}
