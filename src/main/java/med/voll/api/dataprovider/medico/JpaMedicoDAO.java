package med.voll.api.dataprovider.medico;


import med.voll.api.core.entities.BusinessException;
import med.voll.api.core.entities.medico.Medico;
import med.voll.api.core.entities.medico.MedicoRepository;
import med.voll.api.dataprovider.entities.MedicoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class JpaMedicoDAO implements MedicoRepository {

    @Autowired
    private final JpaMedicoRepository repository;

    public JpaMedicoDAO(JpaMedicoRepository repository) {
        this.repository = repository;
    }

   @Transactional
    @Override
    public void cadastrar(Medico novoMedico) {
       MedicoEntity medico = new MedicoEntity(novoMedico);
       try{repository.save(medico);
       } catch (Exception e) {
            throw new BusinessException(BusinessException.getFullMessage(e));
       }
   }

    public Page<MedicoEntity> listarTodosMedicos(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
