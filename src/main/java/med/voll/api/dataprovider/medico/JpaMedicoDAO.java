package med.voll.api.dataprovider.medico;


import lombok.NonNull;
import med.voll.api.core.entities.BusinessException;
import med.voll.api.core.entities.medico.Medico;
import med.voll.api.core.entities.medico.MedicoRepository;
import med.voll.api.dataprovider.converters.MedicoEntityToMedicoConversor;
import med.voll.api.dataprovider.converters.MedicoToMedicoEntityConversor;
import med.voll.api.dataprovider.entities.MedicoEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class JpaMedicoDAO implements MedicoRepository {

    private final JpaMedicoRepository repository;

    private final MedicoToMedicoEntityConversor medicoToMedicoEntityConverter;
    private final MedicoEntityToMedicoConversor medicoEntityToMedicoConversor;

    public JpaMedicoDAO(JpaMedicoRepository repository, MedicoToMedicoEntityConversor conversor, MedicoEntityToMedicoConversor medicoEntityToMedicoConversor) {
        this.repository = repository;
        this.medicoToMedicoEntityConverter = conversor;
        this.medicoEntityToMedicoConversor = medicoEntityToMedicoConversor;
    }

   @Transactional
    @Override
    public void cadastrar(Medico novoMedico) {
       MedicoEntity medico = this.medicoToMedicoEntityConverter.executar(novoMedico);
       try{repository.save(medico);
       } catch (Exception e) {
            throw new BusinessException(BusinessException.getFullMessage(e));
       }
   }

    @Override
    public Medico recuperarUmMedico(Long id) {
        MedicoEntity medico = this.repository.findById(id).get();
        return this.medicoEntityToMedicoConversor.executar(medico);
    }

    public Page<MedicoEntity> listarTodosMedicos(Pageable pageable) {
        return this.repository.findAllByFlagAtivoTrue(pageable);
    }


    @Transactional
    public void atualizar(@NonNull Medico medico){
        this.repository.update(medico.getNome(), medico.getTelefone(), medico.getEndereco(), medico.getId());
    }

    public void deletar(Medico medico) {

        this.repository.logicalDeleteById(medico.getId());
    }
}
