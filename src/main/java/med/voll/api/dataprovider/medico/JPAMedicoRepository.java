package med.voll.api.dataprovider.medico;


import med.voll.api.core.entities.medico.Medico;
import med.voll.api.core.entities.medico.MedicoRepository;
import med.voll.api.dataprovider.entities.MedicoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JPAMedicoRepository implements MedicoRepository {

    @Autowired
    private final JpaMedicoDAO manager;

    public JPAMedicoRepository(JpaMedicoDAO manager) {
        this.manager = manager;
    }

   @Transactional
    @Override
    public void cadastrar(Medico novoMedico) {
       MedicoEntity medico = new MedicoEntity(novoMedico);
        manager.save(medico);
        System.out.println("Salvei o medico no banco de dados");
    }
}
